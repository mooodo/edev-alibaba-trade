package com.edev.trade.customer.service.impl;

import com.edev.support.exception.ValidException;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.entity.JournalAccount;
import com.edev.trade.customer.service.AccountAggService;
import com.edev.trade.customer.service.AccountService;
import com.edev.trade.customer.service.JournalAccountService;
import io.seata.core.context.RootContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountAggServiceImpl implements AccountAggService {
    private final Log log = LogFactory.getLog(AccountAggServiceImpl.class);
    @Autowired
    private AccountService accountService;
    @Autowired
    private JournalAccountService journalAccountService;
    @Override
    @Transactional
    public Double topUp(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%d] or amount[%f] is null", id, amount);
        Account account = accountService.get(id);
        if(account==null)
            throw new ValidException("The account[id:%d] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        accountService.modify(account);

        JournalAccount journalAccount = JournalAccount.build()
                .setValues(account.getId(), amount, "topUp");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }

    @Override
    @Transactional
    public Double payoff(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%d] or amount[%f] is null", id, amount);

        log.info("begin the trade... xid: "+ RootContext.getXID());
        Account account = accountService.get(id);
        if(account==null)
            throw new ValidException("The account[id:%d] isn't available", id);
        if(account.getBalance() < amount)
            throw new ValidException("The account[id:%d] has no enough money[%f]", id, account.getBalance());
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        accountService.modify(account);

        JournalAccount journalAccount = JournalAccount.build()
                .setValues(account.getId(), amount, "payoff");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }

    @Override
    @Transactional
    public Double refund(Long id, Double amount) {
        if(id==null||amount==null)
            throw new ValidException("The id[%d] or amount[%f] is null", id, amount);
        log.info("begin the trade... xid: "+ RootContext.getXID());
        Account account = accountService.get(id);
        if(account==null)
            throw new ValidException("The account[id:%d] isn't available", id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        accountService.modify(account);

        JournalAccount journalAccount = JournalAccount.build()
                .setValues(account.getId(), amount, "refund");
        journalAccountService.addJournalAccount(journalAccount);
        return balance;
    }
}
