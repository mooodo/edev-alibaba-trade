package com.edev.trade.order.service.impl;

import com.edev.support.ddd.NullEntityException;
import com.edev.support.exception.ValidException;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.order.entity.Payment;
import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.CustomerService;
import com.edev.trade.order.service.InventoryService;
import com.edev.trade.order.service.OrderAggService;
import com.edev.trade.order.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderAggServiceImpl implements OrderAggService {
    private final static Log log = LogFactory.getLog(OrderAggServiceImpl.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;
    @Override
    @GlobalTransactional(name = "seata-group-trade", rollbackFor = Exception.class)
    @Transactional
    public Long placeOrder(Order order) {
        if (order==null) throw new NullEntityException();
        log.info("begin the trade... xid: "+ RootContext.getXID());
        Long orderId = orderService.create(order);
        log.debug(String.format("create an order: [orderId: %d]", orderId));

        Payment payment = order.getPayment();
        if(payment==null) throw new OrderException("no payment in the order[orderId:%d]", orderId);
        Double balance = customerService.payoff(payment.getAccountId(), payment.getAmount());
        log.debug(String.format("payoff for the order: [orderId:%d,accountId:%d,amount:%f,balance:%f]",
                orderId, payment.getAccountId(), payment.getAmount(), balance));

        stockOut(order);
        return orderId;
    }

    private void stockOut(Order order) {
        List<Map<String, Long>> list = convertOrderItemsToList(order);
        inventoryService.stockOutForList(list);
        log.debug("stock out for orders");
    }

    private List<Map<String, Long>> convertOrderItemsToList(Order order) {
        List<Map<String, Long>> list = new ArrayList<>();
        for(OrderItem orderItem : order.getOrderItems()) {
            Map<String, Long> map = new HashMap<>();
            map.put("id", orderItem.getProductId());
            map.put("quantity", orderItem.getQuantity());
            list.add(map);
        }
        return list;
    }

    @Override
    @GlobalTransactional(name = "seata-group-trade", rollbackFor = Exception.class)
    @Transactional
    public void returnGoods(Long orderId) {
        if(orderId==null) throw new ValidException("The order id is null!");
        log.info("begin the trade... xid: "+ RootContext.getXID());
        Order order = orderService.load(orderId);
        orderService.delete(orderId);
        log.debug(String.format("return the goods: [orderId: %d]", orderId));

        Payment payment = order.getPayment();
        if(payment==null) throw new OrderException("no payment in the order[orderId:%d]", orderId);
        Double balance = customerService.refund(payment.getAccountId(), payment.getAmount());
        log.debug(String.format("refund goods for the order: [orderId:%d,accountId:%d,amount:%f,balance:%f]",
                orderId, payment.getAccountId(), payment.getAmount(), balance));

        stockIn(order);
    }

    private void stockIn(Order order) {
        List<Map<String, Long>> list = convertOrderItemsToList(order);
        inventoryService.stockInForList(list);
        log.debug("stock in for orders");
    }
}
