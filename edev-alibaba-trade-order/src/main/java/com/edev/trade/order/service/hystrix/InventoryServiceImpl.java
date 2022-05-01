package com.edev.trade.order.service.hystrix;

import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.InventoryService;
import org.springframework.stereotype.Component;

@Component
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Long stockOut(Long id, Long quantity) {
        throw new OrderException("do stock out failure! [productId:%s]", id);
    }
}
