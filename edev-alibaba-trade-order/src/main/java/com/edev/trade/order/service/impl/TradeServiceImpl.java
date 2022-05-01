package com.edev.trade.order.service.impl;

import com.edev.trade.order.entity.Order;
import com.edev.trade.order.service.CustomerService;
import com.edev.trade.order.service.InventoryService;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.order.service.TradeService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TradeServiceImpl implements TradeService {
    private final static Log log = LogFactory.getLog(TradeServiceImpl.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private InventoryService inventoryService;
    @Override
    @GlobalTransactional(name = "seata-group-trade", rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    public Long doTrade(Order order) {
        Long orderId = orderService.create(order);
        log.debug("create an order: [orderId: "+orderId+"]");
        Double balance = customerService.payoff(order.getCustomerId(), order.getAmount());
        log.debug("pay off the order: [account balance: "+balance+"]");
        stockOut(order);
        return orderId;
    }

    private void stockOut(Order order) {
        order.getOrderItems().forEach(orderItem -> {
            Long productId = orderItem.getProductId();
            Long quantity = orderItem.getQuantity();
            Long balance = inventoryService.stockOut(productId, quantity);
            log.debug("stock out for order: [productId:"+productId+",quantity:"+quantity+
                    ",balance:"+balance+"]");
        });
    }
}
