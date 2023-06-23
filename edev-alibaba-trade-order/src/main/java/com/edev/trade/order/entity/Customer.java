package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Entity<Long> {
	private Long id;
	private String name;
	private String gender;
	private Date birthdate;
	private String identification;
	private String phoneNumber;
	public static Customer build() {
		return new Customer();
	}
	public Customer setValues(Long id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		return this;
	}
}
