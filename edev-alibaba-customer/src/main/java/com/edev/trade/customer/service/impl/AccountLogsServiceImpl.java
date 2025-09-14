package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.trade.customer.entity.AccountLogs;
import com.edev.trade.customer.service.AccountLogsService;
import lombok.NonNull;

import java.util.Collection;

import static com.edev.support.utils.ValidUtils.*;

public class AccountLogsServiceImpl implements AccountLogsService {
    private final BasicDao dao;
    public AccountLogsServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    @Override
    public Long addAccountLogs(@NonNull AccountLogs accountLogs) {
        isNull(accountLogs.getAccountId(), "The account id is null");
        return dao.insert(accountLogs);
    }

    @Override
    public void removeAccountLogs(@NonNull Long id) {
        dao.delete(id, AccountLogs.class);
    }

    @Override
    public AccountLogs load(@NonNull Long id) {
        return dao.load(id, AccountLogs.class);
    }

    @Override
    public Collection<AccountLogs> getAccountLogs(@NonNull Long accountId) {
        AccountLogs accountLogs = new AccountLogs();
        accountLogs.setAccountId(accountId);
        return dao.loadAll(accountLogs);
    }
}
