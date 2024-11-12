package com.pluralsight.toppings;

public class Sauce extends Topping{

    public Sauce(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return 0;
    }

}
