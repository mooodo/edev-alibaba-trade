package com.edev.trade.order.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SilverVip extends Vip {

    @Override
    public Double discount() {
        return 0.9D;
    }
}
