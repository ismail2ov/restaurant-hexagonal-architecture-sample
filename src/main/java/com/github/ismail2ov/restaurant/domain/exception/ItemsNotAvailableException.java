package com.github.ismail2ov.restaurant.domain.exception;

public class ItemsNotAvailableException extends RuntimeException {

    public ItemsNotAvailableException(String message) {
        super(message);
    }
}
