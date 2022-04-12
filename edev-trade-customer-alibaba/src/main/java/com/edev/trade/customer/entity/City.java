/*
 * Created by 2021-02-25 22:36:30 
 */
package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;

/**
 * @author fangang
 */
public class City extends Entity<Long> {
	private Long id;
	private String name;
	private Long provinceId;

	@Override
	public Long getId() {
		return id;
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
	 * @return the provinceId
	 */
	public Long getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId the provinceId to set
	 */
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

}
