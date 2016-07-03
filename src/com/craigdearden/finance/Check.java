package com.craigdearden.finance;

public class Check implements Payment {

    private final double amount;
    private final long routingNumber;
    private final long accountNumber;
    private final long checkNumber;

    Check(double amount, long routingNumber, long accountNumber,
            long checkNumber) {
        this.amount = amount;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.checkNumber = checkNumber;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the routingNumber
     */
    public long getRoutingNumber() {
        return routingNumber;
    }

    /**
     * @return the accountNumber
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the checkNumber
     */
    public long getCheckNumber() {
        return checkNumber;
    }
    
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
