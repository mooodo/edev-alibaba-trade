package com.edev.trade.order.service.fallback;

import com.edev.trade.order.entity.Vip;
import com.edev.trade.order.service.VipService;
import org.springframework.stereotype.Component;

@Component
public class VipServiceImpl implements VipService {

    @Override
    public Double discount(Long customerId) {
        return 1D;
    }

    @Override
    public Vip loadByCustomer(Long customerId) {
        return null;
    }
}
