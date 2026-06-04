package com.edev.trade.inventory;

import com.edev.support.dao.BasicDao;
import com.edev.support.dao.QueryDao;
import com.edev.support.ddd.AutofillQueryServiceImpl;
import com.edev.support.ddd.QueryDaoMybastisImplForDdd;
import com.edev.support.query.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QryConfig {
    @Autowired
    @Qualifier("repositoryWithCache")
    private BasicDao repositoryWithCache;
    @Bean
    public QueryDao inventoryQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.inventory.entity.Inventory",
                "com.edev.trade.query.dao.InventoryMapper");
    }
    @Bean
    public QueryService inventoryQry() {
        return new AutofillQueryServiceImpl(
                inventoryQryDao(), repositoryWithCache);
    }
}
