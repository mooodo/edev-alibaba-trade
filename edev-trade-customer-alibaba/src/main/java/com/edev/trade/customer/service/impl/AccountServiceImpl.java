package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AccountServiceImpl implements AccountService {
    private final static Log log = LogFactory.getLog(AccountServiceImpl.class);
    private BasicDao dao;

    public BasicDao getDao() {
        return dao;
    }

    public void setDao(BasicDao dao) {
        this.dao = dao;
    }

    private void validAccount(Account account) {
        if(account.getId()==null) throw new ValidException("The id is null");
    }

    @Override
    public Long createAccount(Account account) {
        validAccount(account);
        if(account.getBalance()==0) account.setBalance(0D);
        if(account.getCreateTime()==null) account.setCreateTime(DateUtils.getNow());
        return dao.insert(account);
    }

    @Override
    public void modifyAccount(Account account) {
        validAccount(account);
        account.setUpdateTime(DateUtils.getNow());
        dao.update(account);
    }

    @Override
    public void removeAccount(Long id) {
        dao.delete(id, Account.class);
    }

    @Override
    public Account getAccount(Long id) {
        return dao.load(id, Account.class);
    }

    @Override
    public Double topUp(Long id, Double amount) {
        Account account = getAccount(id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }

    @Override
    public Double payoff(Long id, Double amount) {
        Account account = getAccount(id);
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }
}
