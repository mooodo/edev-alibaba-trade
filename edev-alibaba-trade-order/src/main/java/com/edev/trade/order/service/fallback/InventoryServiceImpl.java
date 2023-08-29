package com.edev.trade.order.service.fallback;

import com.edev.trade.order.exception.OrderException;
import com.edev.trade.order.service.InventoryService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class InventoryServiceImpl implements InventoryService {
    @Override
    public Long stockIn(Long id, Long quantity) {
        throw new OrderException("do stock in failure! [productId:%s]", id);
    }

    @Override
    public void stockInForList(List<Map<String, Long>> list) {
        throw new OrderException("do stock in failure because of time out!");
    }

    @Override
    public Long stockOut(Long id, Long quantity) {
        throw new OrderException("do stock out failure because of time out! [productId:%s]", id);
    }

    @Override
    public void stockOutForList(List<Map<String, Long>> list) {
        throw new OrderException("do stock out failure because of time out!");
    }
}
