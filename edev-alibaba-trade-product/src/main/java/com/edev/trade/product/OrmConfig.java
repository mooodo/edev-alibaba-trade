package com.edev.trade.product;

import com.edev.support.dao.BasicDao;
import com.edev.trade.product.service.ProductService;
import com.edev.trade.product.service.SupplierService;
import com.edev.trade.product.service.impl.ProductServiceImpl;
import com.edev.trade.product.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrmConfig {
    @Autowired @Qualifier("repositoryWithCache")
    private BasicDao repositoryWithCache;
    @Bean
    public ProductService product() {
        return new ProductServiceImpl(repositoryWithCache);
    }
    @Bean
    public SupplierService supplier() {
        return new SupplierServiceImpl(repositoryWithCache);
    }
}
