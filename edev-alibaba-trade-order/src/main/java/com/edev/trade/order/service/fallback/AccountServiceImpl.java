package com.edev.trade.order.service.fallback;

import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountServiceImpl implements AccountService {

    @Override
    public Double payoff(Long id, Double amount) {
        throw new OrderException("do payoff failure! [orderId:%s]", id);
    }

    @Override
    public Double refund(Long id, Double amount) {
        throw new OrderException("do refund failure! [orderId:%s]", id);
    }
}
