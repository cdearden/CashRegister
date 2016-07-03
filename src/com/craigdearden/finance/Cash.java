package com.craigdearden.finance;

public final class Cash implements Payment {

    /**
     * The total cash amount.
     */
    private double amount;
    
    /**
     * The cash amount represented in bills and coins
     */
    private int hundreds;
    private int fifties;
    private int twenties;
    private int tens;
    private int fives;
    private int twos;
    private int ones;
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    Cash() {}

    /** 
     * Uses the builder pattern to construct a cash object.
     * 
     * @param cb a Cash builder.
     */
    private Cash(Builder cb) {
        this.amount = cb.amount;
        this.hundreds = cb.hundreds;
        this.fifties = cb.fifties;
        this.twenties = cb.twenties;
        this.tens = cb.tens;
        this.fives = cb.fives;
        this.twos = cb.twos;
        this.ones = cb.ones;
        this.quarters = cb.quarters;
        this.dimes = cb.dimes;
        this.nickels = cb.nickels;
        this.pennies = cb.pennies;
    }

    /**
     * Converts a double into the lease number of bills and coins.
     * 
     * @param amount The total cash amount.
     */
    public Cash(double amount) {
        this.amount = amount;

        /* 
         * Find someway to simplify constructors. Also, this is used mainly for 
         * the payment and change when a double is converted into bills in the
         * case of we would have to determine what bills are in the till.  We 
         * might not have 50's, or 2's
         */
        hundreds = (int) (amount / 100);
        fifties = (int) ((amount % 100) / 50);
        twenties = (int) ((amount % 50) / 20);
        tens = (int) ((amount % 20) / 10);
        fives = (int) ((amount % 10) / 5);
        twos = (int) ((amount % 5) / 2);
        ones = (int) ((amount % 2) / 1);
        quarters = (int) ((amount % 1) / 0.25);
        amount = (amount % 1) - quarters * 0.25;
        dimes = (int) (amount / 0.1);
        amount -= dimes * 0.1;
        nickels = (int) ((amount % 0.1) / 0.05);
        amount -= nickels * 0.05;
        pennies = (int) ((amount % 0.05) / 0.01);
    }

    /**
     * @return the hundreds
     */
    public int getHundreds() {
        return hundreds;
    }

    /**
     * @param hundreds the hundreds to set
     */
    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    /**
     * @return the fifties
     */
    public int getFifties() {
        return fifties;
    }

    /**
     * @param fifties the fifties to set
     */
    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    /**
     * @return the twenties
     */
    public int getTwenties() {
        return twenties;
    }

    /**
     * @param twenties the twenties to set
     */
    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    /**
     * @return the tens
     */
    public int getTens() {
        return tens;
    }

    /**
     * @param tens the tens to set
     */
    public void setTens(int tens) {
        this.tens = tens;
    }

    /**
     * @return the fives
     */
    public int getFives() {
        return fives;
    }

    /**
     * @param fives the fives to set
     */
    public void setFives(int fives) {
        this.fives = fives;
    }

    /**
     * @return the twos
     */
    public int getTwos() {
        return twos;
    }

    /**
     * @param twos the twos to set
     */
    public void setTwos(int twos) {
        this.twos = twos;
    }

    /**
     * @return the ones
     */
    public int getOnes() {
        return ones;
    }

    /**
     * @param ones the ones to set
     */
    public void setOnes(int ones) {
        this.ones = ones;
    }

    /**
     * @return the quarters
     */
    public int getQuarters() {
        return quarters;
    }

    /**
     * @param quarters the quarters to set
     */
    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    /**
     * @return the dimes
     */
    public int getDimes() {
        return dimes;
    }

    /**
     * @param dimes the dimes to set
     */
    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    /**
     * @return the nickels
     */
    public int getNickels() {
        return nickels;
    }

    /**
     * @param nickels the nickels to set
     */
    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    /**
     * @return the pennies
     */
    public int getPennies() {
        return pennies;
    }

    /**
     * @param pennies the pennies to set
     */
    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Adds bills and coins to this object.
     * 
     * @param cash The cash to be added to this cash object
     */
    public void addCash(Cash cash) {
        hundreds += cash.getHundreds();
        fifties += cash.getFifties();
        twenties += cash.getTwenties();
        tens += cash.getTens();
        fives += cash.getFives();
        twos += cash.getTwos();
        ones += cash.getOnes();
        quarters += cash.getQuarters();
        dimes += cash.getDimes();
        nickels += cash.getNickels();
        pennies += cash.getPennies();

        amount += cash.getAmount();
    }

    /**
     * Verifies that there are enough physical bills to take from this cash 
     * object then it subtracts bills and coins from this object.
     * 
     * @param cash The cash to be subtracted from this cash object
     */
    public void removeCash(Cash cash) throws InsufficientFundsException {
        /*
         * Note: this doesn't yet take into account that if we are out of 
         * twenties in this cash object we can still subtract twenty dollars if
         * we have two tens.
        */
        if (!nonnegativeResult(cash)) {
            throw new InsufficientFundsException();
        }

        hundreds -= cash.getHundreds();
        fifties -= cash.getFifties();
        twenties -= cash.getTwenties();
        tens -= cash.getTens();
        fives -= cash.getFives();
        twos -= cash.getTwos();
        ones -= cash.getOnes();
        quarters -= cash.getQuarters();
        dimes -= cash.getDimes();
        nickels -= cash.getNickels();
        pennies -= cash.getPennies();

        amount -= cash.getAmount();
    }

    /**
     *  
     * @param cash The cash to be subtracted from this cash object
     * @return true if the number of bills of each type in this object exceeds
     * the number of bills of each type in the cash object to be subtracted.
     * Otherwise it returns false.
     */
    private boolean nonnegativeResult(Cash cash) {
        return hundreds - cash.getHundreds() < 0 ||
                fifties - cash.getFifties() < 0 ||
                twenties - cash.getTwenties() < 0 || tens - cash.getTens() < 0 ||
                fives - cash.getFives() < 0 || twos - cash.getTwos() < 0 ||
                ones - cash.getOnes() < 0 || quarters - cash.getQuarters() < 0 ||
                dimes - cash.getDimes() < 0 || nickels - cash.getNickels() < 0 ||
                pennies - cash.getPennies() < 0;
    }

    /**
     * The <code>Cash</code> object builder
     */
    public static class Builder {

        private double amount;

        private int hundreds;
        private int fifties;
        private int twenties;
        private int tens;
        private int fives;
        private int twos;
        private int ones;
        private int quarters;
        private int dimes;
        private int nickels;
        private int pennies;

        public Builder(double amount) {
            this.amount = amount;
        }

        public Builder hundreds(int hundreds) {
            this.hundreds = hundreds;
            return this;
        }

        public Builder fifties(int fifties) {
            this.fifties = fifties;
            return this;
        }

        public Builder twenties(int twenties) {
            this.twenties = twenties;
            return this;
        }

        public Builder tens(int tens) {
            this.tens = tens;
            return this;
        }

        public Builder fives(int fives) {
            this.fives = fives;
            return this;
        }

        public Builder twos(int twos) {
            this.twos = fives;
            return this;
        }

        public Builder ones(int ones) {
            this.ones = ones;
            return this;
        }

        public Builder quarters(int quarters) {
            this.quarters = quarters;
            return this;
        }

        public Builder dimes(int dimes) {
            this.dimes = dimes;
            return this;
        }

        public Builder nickels(int nickels) {
            this.nickels = nickels;
            return this;
        }

        public Builder pennies(int pennies) {
            this.pennies = pennies;
            return this;
        }

        public Cash build() {
            return new Cash(this);
        }
    }

}
