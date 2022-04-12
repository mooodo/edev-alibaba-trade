package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;

import java.util.Date;

public class Account extends Entity<Long> {
    private Long id;
    private Double balance;
    private Date createTime;
    private Date updateTime;
    private Customer customer;

    public Account() { }

    public Account(Long id, Double balance, Date createTime, Date updateTime) {
        this.id = id;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
