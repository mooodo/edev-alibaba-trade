package com.edev.trade.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class VipDiscount extends Discount {
    private String vipType;
}
