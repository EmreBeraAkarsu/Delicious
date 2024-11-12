package com.pluralsight.toppings;

public class Meat extends Topping{
    public Meat(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return 0;
    }
}
