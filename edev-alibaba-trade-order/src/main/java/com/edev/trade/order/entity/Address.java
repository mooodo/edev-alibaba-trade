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
	private Long districtId;
	private String addressDetail;
	private String phoneNumber;
	public Address() {}
	public Address(Long id, String addressDetail) {
		this.id = id;
		this.addressDetail = addressDetail;
	}
}
