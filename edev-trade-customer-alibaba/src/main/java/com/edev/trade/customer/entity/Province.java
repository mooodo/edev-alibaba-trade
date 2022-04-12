/*
 * Created by 2021-02-25 22:33:07 
 */
package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;

/**
 * @author fangang
 */
public class Province extends Entity<Long> {
	private Long id;
	private String name;
	private Long countryId;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the countryId
	 */
	public Long getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

}
