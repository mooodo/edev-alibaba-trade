package com.edev.trade.customer.entity;

public class SilverVip extends Vip {
    public SilverVip() { super(); }

    public SilverVip(Long id, Boolean available, Long coin) {
        super(id, available, coin, "silver");
    }
}
