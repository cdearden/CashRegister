package com.craigdearden.finance;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds.");
    }

}
