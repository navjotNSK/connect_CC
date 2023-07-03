package com.Connect_CC.BudgetCalculator.exception;

import lombok.Data;

@Data
public class CustomCalException extends RuntimeException {
    private String errorCode;

    public CustomCalException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
