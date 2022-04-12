package com.edev.trade.customer.service;

import com.edev.trade.customer.entity.Account;

public interface AccountService {
    Long createAccount(Account account);
    void modifyAccount(Account account);
    void removeAccount(Long id);
    Account getAccount(Long id);
    Double topUp(Long id, Double amount);
    Double payoff(Long id, Double amount);
}
