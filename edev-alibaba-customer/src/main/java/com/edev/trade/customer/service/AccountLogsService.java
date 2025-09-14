package com.edev.trade.customer.service;

import com.edev.trade.customer.entity.AccountLogs;

import java.util.Collection;

public interface AccountLogsService {
    Long addAccountLogs(AccountLogs accountLogs);
    void removeAccountLogs(Long id);
    AccountLogs load(Long id);
    Collection<AccountLogs> getAccountLogs(Long accountId);
}
