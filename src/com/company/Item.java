package com.company;

public class Item {
    private String name;
    private String price;

    public Item(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item name: " + this.getName() +
                "-" + "Price: " + this.getPrice();
    }

}
