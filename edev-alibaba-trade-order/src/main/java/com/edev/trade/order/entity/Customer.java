package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Entity<Long> {
	private Long id;
	private String name;
	private String gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	private String identification;
	private String phoneNumber;
	public Customer() {}
	public Customer(Long id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
}
