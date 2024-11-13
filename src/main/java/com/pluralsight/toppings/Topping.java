package com.pluralsight.toppings;

//Abstract parent class that outlines the required variable and methods the Topping classes need to implement
public abstract class Topping {

    //The type of the topping is stored here
    private String type;

    public Topping(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    //Method to calculate the toppings' prices
    public abstract double calculatePrice(int size);
}
