package com.craigdearden.finance;

import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    
    /**
     * Items purchased in this transaction.
     */
    private  ArrayList<Item> items;
    
    /**
     * Payment received from the customer.
     */
    private  Payment payment;
    
    /**
     * The change to return to the customer.
     */
    private  Cash change;
    
    /**
     * The sub total 
     */
    private  double subTotal;
    
    /**
     * The tax.
     */
    private  double tax;
    
    /**
     * The total cost of items and tax.
     */
    private  double total;
    
    /**
     * Date of this transaction.
     */
    private  Date date;

    
    Transaction(ArrayList<Item> items, double subTotal, double tax, double total) {
        this.items = items;
        this.subTotal = subTotal;
        this.tax = tax;
        this.total = total;
        this.date = new Date();
    }

    /**
     * Print the details of this transaction.
     */
    public void print() {
     //   SimpleDateFormat sd = new SimpleDateFormat();
     //   System.out.println(date.toString());
        
        System.out.println("Items: %n" +
                "****************************");

        getItems().stream().forEach((item) -> {
            System.out.println(item);
        });

        System.out.printf("%-14s %-13.2d%n", "SUBTOTAL", getSubTotal());
        System.out.printf("%-14s %-13.2d%n", "TAX", getSubTotal());
        System.out.printf("%-14s %-13.2d%n", "TOTAL", getTotal());
        System.out.printf("%-14s %-13.2d%n", getPayment().getType(),
                getPayment().getAmount());
        System.out.printf("%-14s %-13.2d%n", "CHANGE", getChange().getAmount());
        System.out.println("****************************");
    }

    /**
     * @return the items
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(
            ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * @return the payment
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * @param payment the payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * @return the change
     */
    public Cash getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(Cash change) {
        this.change = change;
    }

    /**
     * @return the subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * @param subTotal the subTotal to set
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
