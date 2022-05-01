package com.edev.trade.order.service;

import com.edev.trade.order.entity.Address;
import com.edev.trade.order.entity.Customer;
import com.edev.trade.order.service.hystrix.CustomerServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "service-customer", fallback = CustomerServiceImpl.class)
public interface CustomerService {
    @GetMapping("customer/load")
    Customer load(@RequestParam Long customerId);
    @PostMapping("customer/loadAll")
    List<Customer> loadAll(@RequestBody List<Long> customerIds);
    @GetMapping("customer/loadAddress")
    Address loadAddress(@RequestParam Long addressId);
    @PostMapping("customer/loadAddresses")
    List<Address> loadAddresses(@RequestBody List<Long> addressIds);
    @GetMapping("vip/discount")
    Double discount(@RequestParam Long customerId);
    @GetMapping("account/payoff")
    Double payoff(@RequestParam Long id, @RequestParam Double amount);
}
