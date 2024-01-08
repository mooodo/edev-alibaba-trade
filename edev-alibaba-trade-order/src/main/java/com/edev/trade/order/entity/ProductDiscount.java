package com.edev.trade.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDiscount extends Discount {
    private Long productId;
}
