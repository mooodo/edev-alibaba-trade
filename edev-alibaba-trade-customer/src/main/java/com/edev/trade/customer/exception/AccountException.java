package com.edev.trade.customer.exception;

public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
    public AccountException(String message, Throwable e) {
        super(message, e);
    }
    public AccountException(String message, Object...args) {
        super(String.format(message, args));
    }
    public AccountException(String message, Throwable e, Object...args) {
        super(String.format(message, args), e);
    }
}
