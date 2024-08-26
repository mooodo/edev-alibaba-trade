package com.edev.trade.order.service;

import com.edev.trade.order.service.fallback.AccountServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "service-customer", fallback = AccountServiceImpl.class)
public interface AccountService {
    @GetMapping("account/payoff")
    Double payoff(@RequestParam Long id, @RequestParam Double amount);
    @GetMapping("account/refund")
    Double refund(@RequestParam Long id, @RequestParam Double amount);
}
