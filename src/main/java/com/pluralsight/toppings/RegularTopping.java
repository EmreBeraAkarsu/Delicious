package com.pluralsight.toppings;

public class RegularTopping extends Topping{


    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double calculatePrice(int size) {
        return 0;
    }
}
