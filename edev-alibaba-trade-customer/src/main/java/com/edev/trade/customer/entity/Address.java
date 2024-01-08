package com.edev.trade.customer.entity;

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
	private Country country;
	private Province province;
	private City city;
	private Zone zone;
	private String address;
	private String phoneNumber;
}
