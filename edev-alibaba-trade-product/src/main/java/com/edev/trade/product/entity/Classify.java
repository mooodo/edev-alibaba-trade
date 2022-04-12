/*
 * Created by 2021-02-26 00:46:07 
 */
package com.edev.trade.product.entity;

import com.edev.support.entity.Entity;

/**
 * @author fangang
 */
public class Classify extends Entity<Long> {
	private static final long serialVersionUID = -3764029770647081900L;
	private Long id;
	private String name;
	private Long parentId;
	private Integer layer;

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
	 * @return the parentId
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the layer
	 */
	public Integer getLayer() {
		return layer;
	}

	/**
	 * @param layer the layer to set
	 */
	public void setLayer(Integer layer) {
		this.layer = layer;
	}

}
