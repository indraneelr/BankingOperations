package com.bank.xyzbank.exception;

public class InvalidOperationException extends Exception {
    public InvalidOperationException(String errorMessage) {
        super(errorMessage);
    }
}
