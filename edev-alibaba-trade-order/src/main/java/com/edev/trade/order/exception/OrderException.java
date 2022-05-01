package com.edev.trade.order.exception;

public class OrderException extends RuntimeException {
    public OrderException(String message) {
        super(message);
    }
    public OrderException(String message, Throwable e) {
        super(message, e);
    }
    public OrderException(String message, Object...args) {
        super(String.format(message, args));
    }
    public OrderException(String message, Throwable e, Object...args) {
        super(String.format(message, args), e);
    }
}
