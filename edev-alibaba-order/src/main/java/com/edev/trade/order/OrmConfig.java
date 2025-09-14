package com.edev.trade.order;

import com.edev.support.dao.BasicDao;
import com.edev.trade.order.service.DiscountService;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.order.service.impl.DiscountServiceImpl;
import com.edev.trade.order.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrmConfig {
    @Autowired @Qualifier("basicDao")
    private BasicDao basicDao;
    @Autowired @Qualifier("repository")
    private BasicDao repository;
    @Bean
    public OrderService order() {
        return new OrderServiceImpl(repository);
    }
    @Bean
    public DiscountService discount() {
        return new DiscountServiceImpl(basicDao);
    }
}
