package com.edev.trade.customer;

import com.edev.support.dao.BasicDao;
import com.edev.trade.customer.service.*;
import com.edev.trade.customer.service.impl.*;
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
    public CustomerService customer() {
        return new CustomerServiceImpl(repository);
    }
    @Bean
    public VipService vip() {
        return new VipServiceImpl(repository);
    }
    @Bean
    public AccountService account() {
        return new AccountServiceImpl(repository);
    }
    @Bean
    public JournalAccountService journalAccount() {
        return new JournalAccountServiceImpl(basicDao);
    }
}
