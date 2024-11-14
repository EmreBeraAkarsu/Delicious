package com.pluralsight.items;

//Chip class for creating the chip objects to be stored in the order. This class implements the Item interface.
public class Chip implements IPrice {

    // Type of the chips stored here
    private String type;

    //Constructor
    public Chip(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    //Method for getting the price
    @Override
    public double getPrice() {
        return 1.5;
    }

    //Method to convert the data to a string
    @Override
    public String toString() {
        return "Chip: " + type + " - Price: $" + getPrice();
    }
}
