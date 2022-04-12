package com.edev.trade.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("service-inventory")
public interface InventoryService {
    @GetMapping("orm/inventory/stockOut")
    Long stockOut(@RequestParam Long id, @RequestParam Long quantity);
}
