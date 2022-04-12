package com.edev.trade.order.service;

import com.edev.trade.order.entity.Order;

public interface TradeService {
    Long doTrade(Order order);
}
