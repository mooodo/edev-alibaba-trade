package com.edev.trade.order;

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
    public QueryDao orderQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.order.entity.Order",
                "com.edev.trade.query.dao.OrderMapper");
    }
    @Bean
    public QueryService orderQry() {
        return new AutofillQueryServiceImpl(
                orderQryDao(), repositoryWithCache);
    }

    @Bean
    public QueryDao discountQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.order.entity.Discount",
                "com.edev.trade.query.dao.DiscountMapper");
    }
    @Bean
    public QueryService discountQry() {
        return new AutofillQueryServiceImpl(
                discountQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao productDiscountQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.order.entity.ProductDiscount",
                "com.edev.trade.query.dao.ProductDiscountMapper");
    }
    @Bean
    public QueryService productDiscountQry() {
        return new AutofillQueryServiceImpl(
                productDiscountQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao vipDiscountQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.order.entity.VipDiscount",
                "com.edev.trade.query.dao.VipDiscountMapper");
    }
    @Bean
    public QueryService vipDiscountQry() {
        return new AutofillQueryServiceImpl(
                vipDiscountQryDao(), basicDaoWithCache);
    }
}
