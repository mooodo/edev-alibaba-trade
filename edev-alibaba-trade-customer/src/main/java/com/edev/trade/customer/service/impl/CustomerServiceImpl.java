package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.trade.customer.entity.Address;
import com.edev.trade.customer.entity.Customer;
import com.edev.trade.customer.service.CustomerService;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final BasicDao dao;
    public CustomerServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void validCustomer(@NonNull Customer customer) {
        if(customer.getId()==null) throw new ValidException("The id is null");
        if(customer.getName()==null) throw new ValidException("The name is null");
    }

    @Override
    public Long register(@NonNull Customer customer) {
        validCustomer(customer);
        return dao.insert(customer);
    }

    @Override
    public void modify(@NonNull Customer customer) {
        dao.update(customer);
    }

    @Override
    public void save(@NonNull Customer customer) {
        validCustomer(customer);
        dao.insertOrUpdate(customer);
    }

    @Override
    public void delete(@NonNull Long customerId) {
        dao.delete(customerId, Customer.class);
    }

    @Override
    public Customer load(@NonNull Long customerId) {
        return dao.load(customerId, Customer.class);
    }

    @Override
    public void saveAll(@NonNull List<Customer> customers) {
        customers.forEach(this::validCustomer);
        dao.insertOrUpdateForList(customers);
    }

    @Override
    public void deleteAll(@NonNull List<Long> customerIds) {
        dao.deleteForList(customerIds, Customer.class);
    }

    @Override
    public Collection<Customer> loadAll(@NonNull List<Long> customerIds) {
        return dao.loadForList(customerIds, Customer.class);
    }

    @Override
    public Address loadAddress(@NonNull Long addressId) {
        return dao.load(addressId, Address.class);
    }

    @Override
    public Collection<Address> loadAddresses(@NonNull List<Long> addressIds) {
        return dao.loadForList(addressIds, Address.class);
    }

}
