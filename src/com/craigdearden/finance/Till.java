package com.craigdearden.finance;

import java.util.ArrayList;

public final class Till {

    static {
        INITIAL_CASH = new Cash.Builder(675.00)
                    .tens(40).fives(40).ones(40)
                    .quarters(80).dimes(100).nickels(80).pennies(100)
                    .build();
    }

    /**
     * The cash that the till started with.
     */
    public static final Cash INITIAL_CASH;
    
    /**
     * The checks that were accepted as payment are kept in the till.
     */
    private final ArrayList<Check> checks = new ArrayList<>();
    
    /**
     * The cash in the till at any given moment.
     */
    private final Cash cash;

    Till() {
        cash = INITIAL_CASH;
    }

    /**
     * Analogous to opening the till. Cash may be added or removed from the till.
     * 
     * @return The current cash object in the till.
     */
    public Cash getCash() {
        return cash;
    }

    /**
     * 
     * @return The checks that have been stored in the till.
     */
    public ArrayList<Check> getChecks() {
        return checks;
    }

    /**
     * Add cash to the till.
     * 
     * @param payment Cash payment received from the customer.
     */
    public void addCash(Cash payment) {
        cash.addCash(payment);
    }

    /**
     * Add a check to the till.
     * 
     * @param check Check payment received from the customer.
     */
    public void addCheck(Check check) {
        checks.add(check);
    }
    
    /**
     * 
     * @param change The amount of change required as calculated by 
     * {@link CashRegister#calcualteChange(com.craigdearden.finance.Payment, 
     * double) } Subtracts this amount from the till.
     * @return The amount of change to give to the customer.
     * @throws InsufficientFundsException if there is not enough bills and coins
     * in the register to make the change.
     */   
    public Cash getChange(Cash change) throws InsufficientFundsException {
        cash.removeCash(change);
        return change;
    }

}
