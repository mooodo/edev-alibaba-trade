package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Address extends Entity<Long> {
	private Long id;
	private Long customerId;
	private Long countryId;
	private Long provinceId;
	private Long cityId;
	private Long zoneId;
	private String address;
	private String phoneNumber;
	public static Address build() {
		return new Address();
	}
	public Address setValues(Long id, String address) {
		this.id = id;
		this.address = address;
		return this;
	}
}
