
package com.craigdearden.finance;

public final class Item {
    private final String itemName;
    private final double cost;

    public Item(String itemName, double cost) {
        this.itemName = itemName;
        this.cost = cost;
    }
    
    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }
    
    /**
     * 
     * @return The name of the object and its cost as a String object.
     */
    public String toString() {
        return String.format("%-20s %7f",itemName,cost);
    }
    
}
