package com.edev.trade.order.service.fallback;

import com.edev.trade.order.entity.Address;
import com.edev.trade.order.entity.Customer;
import com.edev.trade.order.entity.Vip;
import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer load(Long customerId) {
        return new Customer(customerId,"Unknown","Unknown");
    }

    @Override
    public List<Customer> loadAll(List<Long> customerIds) {
        List<Customer> list = new ArrayList<>();
        customerIds.forEach(customerId->list.add(load(customerId)));
        return list;
    }

    @Override
    public Address loadAddress(Long addressId) {
        return new Address(addressId,"Unknown");
    }

    @Override
    public List<Address> loadAddresses(List<Long> addressIds) {
        List<Address> list = new ArrayList<>();
        addressIds.forEach(addressId-> list.add(loadAddress(addressId)));
        return list;
    }

    @Override
    public Double discount(Long customerId) {
        return 1D;
    }

    @Override
    public Vip loadByCustomer(Long customerId) {
        return null;
    }

    @Override
    public Double payoff(Long id, Double amount) {
        throw new OrderException("do payoff failure! [orderId:%s]", id);
    }

    @Override
    public Double refund(Long id, Double amount) {
        throw new OrderException("do refund failure! [orderId:%s]", id);
    }
}
