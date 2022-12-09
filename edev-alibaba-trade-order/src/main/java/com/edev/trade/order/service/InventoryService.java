package com.edev.trade.order.service;

import com.edev.trade.order.service.fallback.InventoryServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "service-inventory", fallback = InventoryServiceImpl.class)
public interface InventoryService {
    @GetMapping("orm/inventory/stockIn")
    Long stockIn(@RequestParam Long id, @RequestParam Long quantity);
    @GetMapping("orm/inventory/stockOut")
    Long stockOut(@RequestParam Long id, @RequestParam Long quantity);
}
