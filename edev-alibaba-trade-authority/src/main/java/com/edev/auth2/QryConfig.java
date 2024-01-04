package com.edev.auth2;

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
    @Qualifier("basicDaoWithCache")
    private BasicDao basicDaoWithCache;
    @Bean
    public QueryDao userQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.auth2.authority.entity.User",
                "com.edev.trade.query.dao.UserMapper");
    }
    @Bean
    public QueryService userQry() {
        return new AutofillQueryServiceImpl(
                userQryDao(), basicDaoWithCache);
    }
}
