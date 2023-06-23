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

	public static Address build() {
		return new Address();
	}

	public Address setValues(Long id, Long customerId, Long countryId, Long provinceId,
							 Long cityId, Long zoneId, String address, String phoneNumber) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setCountryId(countryId);
		this.setProvinceId(provinceId);
		this.setCityId(cityId);
		this.setZoneId(zoneId);
		this.setAddress(address);
		this.setPhoneNumber(phoneNumber);
		return this;
	}
}
