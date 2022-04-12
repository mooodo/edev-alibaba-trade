package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.trade.customer.entity.Address;
import com.edev.trade.customer.entity.Customer;
import com.edev.trade.customer.service.CustomerService;

import java.util.Collection;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private BasicDao dao;

    public BasicDao getDao() {
        return dao;
    }

    public void setDao(BasicDao dao) {
        this.dao = dao;
    }

    private void validCustomer(Customer customer) {
        if(customer.getId()==null) throw new ValidException("The id is null");
        if(customer.getName()==null) throw new ValidException("The name is null");
    }

    @Override
    public Long register(Customer customer) {
        validCustomer(customer);
        return dao.insert(customer);
    }

    @Override
    public void modify(Customer customer) {
        validCustomer(customer);
        dao.update(customer);
    }

    @Override
    public void delete(Long customerId) {
        dao.delete(customerId, Customer.class);
    }

    @Override
    public Customer load(Long customerId) {
        return dao.load(customerId, Customer.class);
    }

    @Override
    public void saveAll(List<Customer> customers) {
        customers.forEach(this::validCustomer);
        dao.insertOrUpdateForList(customers);
    }

    @Override
    public void deleteAll(List<Long> customerIds) {
        dao.deleteForList(customerIds, Customer.class);
    }

    @Override
    public Collection<Customer> loadAll(List<Long> customerIds) {
        return dao.loadForList(customerIds, Customer.class);
    }

    @Override
    public Address loadAddress(Long addressId) {
        return dao.load(addressId, Address.class);
    }

    @Override
    public Collection<Address> loadAddresses(List<Long> addressIds) {
        return dao.loadForList(addressIds, Address.class);
    }


}
