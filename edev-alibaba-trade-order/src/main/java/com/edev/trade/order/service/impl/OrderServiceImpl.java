package com.edev.trade.order.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.order.service.CustomerService;
import com.edev.trade.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Autowired
    private CustomerService customerService;
    private BasicDao dao;

    public BasicDao getDao() {
        return dao;
    }

    public void setDao(BasicDao dao) {
        this.dao = dao;
    }

    private void validOrder(Order order) {
        if(order.getId()==null) throw new ValidException("The id is null!");
        if(order.getCustomerId()==null) throw new ValidException("The customerId is null");
        if(order.getAddressId()==null) throw new ValidException("The addressId is null");
    }

    private void discount(Order order) {
        if(order.getOrderItems()==null||order.getOrderItems().isEmpty()) return;
        Double discount = customerService.discount(order.getCustomerId());
        if(discount==null) return;
        order.getOrderItems().forEach(orderItem -> {
            Double amount = order.getAmount() * discount;
            orderItem.setAmount(amount);
        });
    }

    private void sumOfAmount(Order order) {
        if(order.getOrderItems()==null||order.getOrderItems().isEmpty()) return;
        Double amount = 0D;
        for(OrderItem orderItem : order.getOrderItems()) {
            orderItem.setAmount(orderItem.getPrice() * orderItem.getQuantity());
            amount += orderItem.getAmount();
        }
        order.setAmount(amount);
    }

    @Override
    public Long create(Order order) {
        validOrder(order);
        discount(order);
        sumOfAmount(order);
        if(order.getOrderTime()==null) order.setOrderTime(DateUtils.getNow());
        if(order.getFlag()==null) order.setFlag("CREATE");
        return dao.insert(order);
    }

    @Override
    public void modify(Order order) {
        validOrder(order);
        discount(order);
        sumOfAmount(order);
        order.setModifyTime(DateUtils.getNow());
        dao.update(order);
    }

    @Override
    public void delete(Long orderId) {
        dao.delete(orderId, Order.class);
    }

    @Override
    public Order load(Long orderId) {
        return dao.load(orderId, Order.class);
    }

    @Override
    public void saveAll(List<Order> orders) {
        orders.forEach(order -> {
            validOrder(order);
            discount(order);
            sumOfAmount(order);
        });
        dao.insertOrUpdateForList(orders);
    }

    @Override
    public void deleteAll(List<Long> orderIds) {
        dao.deleteForList(orderIds, Order.class);
    }

    @Override
    public Collection<Order> loadAll(List<Long> orderIds) {
        return dao.loadForList(orderIds, Order.class);
    }
}
