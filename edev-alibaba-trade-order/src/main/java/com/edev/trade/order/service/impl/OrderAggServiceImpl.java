package com.edev.trade.order.service.impl;

import com.edev.support.exception.ValidException;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.order.entity.Payment;
import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.*;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderAgg")
@Slf4j
public class OrderAggServiceImpl implements OrderAggService {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private InventoryService inventoryService;
    @Override
    public Long placeOrder(@NonNull Order order) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        Long orderId = orderService.create(order);
        log.debug(String.format("create an order: [orderId: %d]", orderId));
        return orderId;
    }

    @Override
    @GlobalTransactional(name = "seata-group-trade", rollbackFor = Exception.class)
    @Transactional
    public void payoff(@NonNull Order order) {
        if(order.getPayment()==null||order.getPayment().getAccountId()==null)
            throw new ValidException("no account for payoff: [orderId: %s]", order.getId());
        Payment payment = order.getPayment();
        Double balance = accountService.payoff(payment.getAccountId(), payment.getAmount());
        log.debug(String.format("payoff for the order: [orderId:%d,accountId:%d,amount:%f,balance:%f]",
                order.getId(), payment.getAccountId(), payment.getAmount(), balance));
        stockOut(order);
        order.setStatus("PAYOFF");
        order.getPayment().setStatus("PAYOFF");
        orderService.modify(order);
    }

    private void stockOut(@NonNull Order order) {
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
    public void cancelOrder(@NonNull Long orderId) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        Order order = orderService.load(orderId);
        if(order==null) throw new OrderException("no found the order[orderId:%d]", orderId);
        orderService.delete(orderId);
        log.debug(String.format("return the goods: [orderId: %d]", orderId));

        Payment payment = order.getPayment();
        if(payment==null) throw new OrderException("no payment in the order[orderId:%d]", orderId);
        Double balance = accountService.refund(payment.getAccountId(), payment.getAmount());
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
