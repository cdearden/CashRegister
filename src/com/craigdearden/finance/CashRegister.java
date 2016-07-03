package com.craigdearden.finance;

import java.util.ArrayList;

public class CashRegister {

    ArrayList<Transaction> transactions = new ArrayList<>();
    private Transaction currTransaction;
    private Till till;

    public CashRegister(Till till) {
        this.till = till;
    }

    public double scanItems(ArrayList<Item> items) {
        double subTotal = calcualteSubTotal(items);
        double tax = calcualteTax(subTotal);
        double total = calcualteTotal(subTotal, tax);
        currTransaction = new Transaction(items, subTotal, tax, total);
        return total;
    }

    public Cash acceptPayment(Payment payment) {
        Cash change = null;
        if (payment.getAmount() > currTransaction.getTotal()) {
            change = new Cash(payment.getAmount() - currTransaction.getTotal());
        } else {
            change = new Cash();
        }

        currTransaction.setPayment(payment);
        currTransaction.setChange(change);
        printReceipt(currTransaction);
        transactions.add(currTransaction);
        currTransaction = null;
        return change;
    }

    /**
     * @return the till
     */
    public Till getTill() {
        return till;
    }

    private double calcualteSubTotal(ArrayList<Item> items) {
        double subTot = 0;
        for (Item i : items) {
            subTot += i.getCost();
        }
        return subTot;
    }

    private double calcualteTax(double subTotal) {
        return subTotal * 0.0875;
    }

    private double calcualteTotal(double subTotal, double tax) {
        return subTotal + tax;
    }

    private Cash calcualteChange(Payment payment, double total) {
        double change = payment.getAmount() - total;
        return new Cash(change);
    }

    private void printReceipt(Transaction transaction) {
        System.out.println("Thank you for shopping at");
        System.out.println("");
        transaction.print();
    }

    public double balanceRegister() {
        double theoreticalAmount = calcualteCashFlow() +
                getTill().INITIAL_CASH.getAmount();
        double actualAmount = getTill().getCash().getAmount();
        return actualAmount - theoreticalAmount;
    }

    private double calcualteCashFlow() {
        double cashFlow = 0;
        for (Transaction t : transactions) {
            if (t.getClass().equals("cash")) {
                cashFlow += t.getPayment().getAmount();
                cashFlow -= t.getChange().getAmount();
            }
        }
        return cashFlow;
    }

    /**
     * @return the currTransaction
     */
    public Transaction getCurrTransaction() {
        return currTransaction;
    }

}
