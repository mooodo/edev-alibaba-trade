/*
 * created by 2019年7月22日 下午3:20:12
 */
package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;
import com.edev.support.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fangang
 */
public class Order extends Entity<Long> {
	private Long id;
	private Long customerId;
	private Long addressId;
	private Double amount;
	private Date orderTime;
	private Date modifyTime;
	private String flag;
	private Customer customer;
	private Address address;
	private List<OrderItem> orderItems;

	public Order() {}

	public Order(Long id, Long customerId, Long addressId, Double amount, Date orderTime, String flag) {
		this.id = id;
		this.customerId = customerId;
		this.addressId = addressId;
		this.amount = amount;
		this.orderTime = (orderTime==null) ? DateUtils.getNow() : orderTime;
		this.flag = (flag==null) ? "CREATE" : flag;
	}

	public Order(Long id, Long customerId, Long addressId) {
		this.id = id;
		this.customerId = customerId;
		this.addressId = addressId;
		this.amount = 0D;
		this.orderTime = DateUtils.getNow();
		this.flag = "create";
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void addOrderItem(OrderItem orderItem) {
		if(this.orderItems==null) this.orderItems = new ArrayList<>();
		this.orderItems.add(orderItem);
	}

	@Override
	protected String[] exclude() {
		return new String[]{"orderTime","modifyTime"};
	}
}
