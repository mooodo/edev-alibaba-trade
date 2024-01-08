package com.edev.trade.order.service.fallback;

import com.edev.trade.order.entity.Product;
import com.edev.trade.order.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(Long id) {
        return new Product(id,"Unknown","Unknown");
    }

    @Override
    public List<Product> listProducts(List<Long> ids) {
        List<Product> list = new ArrayList<>();
        ids.forEach(id-> list.add(getProduct(id)));
        return list;
    }
}
