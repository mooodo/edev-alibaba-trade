package com.edev.trade.inventory.service;

import com.edev.trade.inventory.entity.Product;
import com.edev.trade.inventory.service.hystrix.ProductServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Service
@FeignClient(value = "service-product", fallback = ProductServiceImpl.class)
public interface ProductService {
    @GetMapping("orm/product/getProduct")
    Product getProduct(@RequestParam Long id);
    @PostMapping("list/product/listProducts")
    Collection<Product> listProducts(@RequestBody List<Long> ids);
}
