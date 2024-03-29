package com.edev.trade.customer;

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
    @Autowired @Qualifier("basicDaoWithCache")
    private BasicDao basicDaoWithCache;
    @Autowired @Qualifier("repositoryWithCache")
    private BasicDao repositoryWithCache;
    @Bean
    public QueryDao customerQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.customer.entity.Customer",
                "com.edev.trade.query.dao.CustomerMapper");
    }
    @Bean
    public QueryService customerQry() {
        return new AutofillQueryServiceImpl(
                customerQryDao(), repositoryWithCache);
    }
    @Bean
    public QueryDao vipQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.customer.entity.Vip",
                "com.edev.trade.query.dao.VipMapper");
    }
    @Bean
    public QueryService vipQry() {
        return new AutofillQueryServiceImpl(
                vipQryDao(), basicDaoWithCache);
    }
}
