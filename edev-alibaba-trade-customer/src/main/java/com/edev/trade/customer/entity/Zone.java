package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Zone extends Entity<Long> {
	private Long id;
	private String name;
	private Long provinceId;
	private Long cityId;
}
