package com.edev.trade.order.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Product extends Entity<Long> {
	private Long id;
	private String name;
	private Double price;
	private String unit;
	private Long supplierId;
	private Long classifyId;
	private String image;
	private Double originalPrice;
	private String tip;
	public Product() {}
	public Product(Long id, String name, String unit) {
		this.id = id;
		this.name = name;
		this.unit = unit;
	}
}
