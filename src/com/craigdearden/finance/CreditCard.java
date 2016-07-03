package com.craigdearden.finance;

public class CreditCard implements Payment {

    private final long cardNumber;
    private final double amount;

    public CreditCard(long cardNumber, double charge) {
        this.cardNumber = cardNumber;
        this.amount = charge;
    }

    /**
     * @return the cardNumber
     */
    public long getCardNumber() {
        return cardNumber;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }
    
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
