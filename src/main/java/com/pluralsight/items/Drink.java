package com.pluralsight.items;

public class Drink implements Item{

    private String size;
    private String flavor;


    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}