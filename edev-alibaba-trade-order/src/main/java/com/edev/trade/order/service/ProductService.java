package com.edev.trade.order.service;

import com.edev.trade.order.entity.Product;
import com.edev.trade.order.service.hystrix.ProductServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@FeignClient(value = "service-product", fallback = ProductServiceImpl.class)
public interface ProductService {
    @GetMapping("product/get")
    Product getProduct(@RequestParam Long id);
    @PostMapping("product/getAll")
    List<Product> listProducts(@RequestBody List<Long> ids);
}
