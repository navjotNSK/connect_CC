package com.Connect_CC.Registration.exception;

import lombok.Data;

@Data
public class CustomRegException extends RuntimeException {
    private String errorCode;

    public CustomRegException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
