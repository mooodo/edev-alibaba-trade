package com.edev.trade.order.service.hystrix;

import com.edev.trade.order.entity.Address;
import com.edev.trade.order.entity.Customer;
import com.edev.trade.order.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer load(Long customerId) {
        return new Customer(customerId,"Unknown","Unknown",null,null);
    }

    @Override
    public List<Customer> loadAll(List<Long> customerIds) {
        List<Customer> list = new ArrayList<>();
        customerIds.forEach(customerId->list.add(load(customerId)));
        return list;
    }

    @Override
    public Address loadAddress(Long addressId) {
        return new Address(addressId,null,null,null,null,null,"Unknown",null);
    }

    @Override
    public List<Address> loadAddresses(List<Long> addressIds) {
        List<Address> list = new ArrayList<>();
        addressIds.forEach(addressId->loadAddress(addressId));
        return list;
    }

    @Override
    public Double discount(Long customerId) {
        return null;
    }

    @Override
    public Double payoff(Long id, Double amount) {
        return null;
    }
}
