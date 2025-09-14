package com.edev.trade.order.service.impl.discount;

import com.edev.trade.order.entity.*;
import com.edev.trade.order.service.DiscountService;
import com.edev.trade.order.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VipDiscountStrategy implements DiscountStrategy {
    @Autowired
    private VipService vipService;
    @Autowired
    private DiscountService discountService;
    @Override
    public void doDiscount(Order order) {
        Vip vip = vipService.loadByCustomer(order.getCustomerId());
        if(vip==null) return;
        VipDiscount template = new VipDiscount();
        template.setVipType(vip.getVipType());
        Discount discount = discountService.load(template);
        if(discount==null) return;
        List<OrderItem> orderItems = order.getOrderItems();
        if(orderItems==null||orderItems.isEmpty()) return;
        orderItems.forEach(orderItem -> {
            if(orderItem.getAmount()==null) return;
            Double amount = orderItem.getAmount() * discount.getDiscount();
            orderItem.setAmount(amount);
        });
    }
}
