package com.company;

public class Item implements Comparable<Item> {
    private String name;
    private double price;

    public Item(){

    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item name: " + this.getName() +
                "-" + "Price: " + this.getPrice();
    }

    @Override
    public int compareTo(Item compareItem) {
        int comparePrice = (int)(compareItem).getPrice();

        /* For Ascending order*/
        return (int)this.price-comparePrice;

        /* For Descending order do like this */
        //return (int)(comparePrice-this.price);
    }
}
