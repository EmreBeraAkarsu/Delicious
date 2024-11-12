package com.pluralsight.toppings;

public class Cheese extends Topping{
    public Cheese(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return .75 * (size / 4);
    }
}
