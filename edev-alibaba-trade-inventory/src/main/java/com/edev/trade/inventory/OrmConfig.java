package com.edev.trade.inventory;

import com.edev.support.dao.BasicDao;
import com.edev.trade.inventory.service.InventoryService;
import com.edev.trade.inventory.service.impl.InventoryServiceImpl;
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
    public InventoryService inventory() {
        return new InventoryServiceImpl(repository);
    }
}
