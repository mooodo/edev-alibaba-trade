package com.edev.trade.product;

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
    public QueryDao productQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.product.entity.Product",
                "com.edev.trade.query.dao.ProductMapper");
    }
    @Bean
    public QueryService productQry() {
        return new AutofillQueryServiceImpl(
                productQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao supplierQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.product.entity.Supplier",
                "com.edev.trade.query.dao.SupplierMapper");
    }
    @Bean
    public QueryService supplierQry() {
        return new AutofillQueryServiceImpl(
                supplierQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao distributorQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.product.entity.Distributor",
                "com.edev.trade.query.dao.DistributorMapper");
    }
    @Bean
    public QueryService distributorQry() {
        return new AutofillQueryServiceImpl(
                distributorQryDao(), basicDaoWithCache);
    }
    @Bean
    public QueryDao vendorQryDao() {
        return new QueryDaoMybastisImplForDdd(
                "com.edev.trade.product.entity.Vendor",
                "com.edev.trade.query.dao.VendorMapper");
    }
    @Bean
    public QueryService vendorQry() {
        return new AutofillQueryServiceImpl(
                vendorQryDao(), basicDaoWithCache);
    }
}
