package com.pluralsight.items;

public class Chip implements Item{

    private String type;

    public Chip(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


    @Override
    public double getPrice() {
        return 1.5;
    }
}
