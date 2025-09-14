package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.entity.AccountLogs;
import com.edev.trade.customer.service.AccountService;
import com.edev.trade.customer.service.AccountLogsService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.edev.support.utils.ValidUtils.*;

public class AccountServiceImpl implements AccountService {
    private final BasicDao dao;
    @Autowired
    private AccountLogsService accountLogsService;
    public AccountServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void validAccount(@NonNull Account account) {
        isNull(account.getId(), "The account id is null");
        isNull(account.getCustomerId(), "The customer id is null");
    }

    @Override
    public Long create(@NonNull Account account) {
        validAccount(account);
        account.setCreateTime(DateUtils.getNow());
        return dao.insert(account);
    }

    @Override
    public void modify(@NonNull Account account) {
        validAccount(account);
        account.setUpdateTime(DateUtils.getNow());
        dao.update(account);
    }

    @Override
    public void remove(@NonNull Long id) {
        dao.delete(id, Account.class);
    }

    @Override
    public Account get(@NonNull Long id) {
        return dao.load(id, Account.class);
    }
    @Override
    @Transactional
    public Double topUp(@NonNull Long id, @NonNull Double amount) {
        Account account = this.get(id);
        isNull(account, "The account[id:%d] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        this.modify(account);

        AccountLogs accountLogs =
                new AccountLogs(account.getId(), amount, "topUp");
        accountLogsService.addAccountLogs(accountLogs);
        return balance;
    }

    @Override
    @Transactional
    public Double payoff(@NonNull Long id, @NonNull Double amount) {
        Account account = this.get(id);
        isNull(account, "The account[id:%d] isn't available", id);
        isError(account.getBalance() < amount,
                "The account[id:%d] has no enough money[%d]", id, account.getBalance());
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        this.modify(account);

        AccountLogs accountLogs =
                new AccountLogs(account.getId(), amount, "payoff");
        accountLogsService.addAccountLogs(accountLogs);
        return balance;
    }

    @Override
    @Transactional
    public Double refund(@NonNull Long id, @NonNull Double amount) {
        Account account = this.get(id);
        isNull(account, "The account[id:%d] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        this.modify(account);

        AccountLogs accountLogs =
                new AccountLogs(account.getId(), amount, "refund");
        accountLogsService.addAccountLogs(accountLogs);
        return balance;
    }
}
