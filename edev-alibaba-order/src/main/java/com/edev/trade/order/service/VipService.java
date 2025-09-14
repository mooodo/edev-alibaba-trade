package com.edev.trade.order.service;

import com.edev.trade.order.entity.Vip;
import com.edev.trade.order.service.fallback.VipServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "service-customer", fallback = VipServiceImpl.class)
public interface VipService {
    @GetMapping("orm/vip/discount")
    Double discount(@RequestParam Long customerId);
    @GetMapping("orm/vip/loadByCustomer")
    Vip loadByCustomer(@RequestParam Long customerId);
}
