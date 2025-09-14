package com.edev.trade.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GoldenVip extends Vip {
    private Double cashback;

    @Override
    public Double discount() {
        return 0.75D;
    }
}
