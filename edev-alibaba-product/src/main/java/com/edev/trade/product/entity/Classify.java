package com.edev.trade.product.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Classify extends Entity<Long> {
	private Long id;
	private String name;
	private Long parentId;
	private Integer layer;
}
