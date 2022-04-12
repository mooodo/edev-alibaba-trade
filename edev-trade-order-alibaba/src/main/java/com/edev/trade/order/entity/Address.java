/*
 * created by 2019年7月22日 下午3:24:47
 */
package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;

/**
 * @author fangang
 */
public class Address extends Entity<Long> {
	private static final long serialVersionUID = -7715747957884378980L;
	private Long id;
	private Long customerId;
	private Long countryId;
	private Long provinceId;
	private Long cityId;
	private Long zoneId;
	private String address;
	private String phoneNumber;

	public Address() {}

	public Address(Long id, Long customerId, Long countryId, Long provinceId, Long cityId, Long zoneId, String address, String phoneNumber) {
		this.id = id;
		this.customerId = customerId;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.cityId = cityId;
		this.zoneId = zoneId;
		this.address = address;
		this.phoneNumber = phoneNumber;
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

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getZoneId() {
		return zoneId;
	}

	public void setZoneId(Long zoneId) {
		this.zoneId = zoneId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
