package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;
import com.edev.support.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountLogs extends Entity<Long> {
    private Long id;
    private Long accountId;
    private Double amount;
    private String operation;
    private Date operateTime;

    public AccountLogs() {}

    public AccountLogs(Long accountId, Double amount, String operation) {
        this(null, accountId, amount, operation, null);
    }

    public AccountLogs(Long id, Long accountId, Double amount, String operation, Date operateTime) {
        setId(id);
        setAccountId(accountId);
        setAmount(amount);
        setOperation(operation);
        setOperateTime(operateTime);
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime==null ? DateUtils.getNow() : operateTime;
    }
}
