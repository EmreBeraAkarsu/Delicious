package com.pluralsight.toppings;

//RegularTopping topping class that is a child class of the Topping class
public class RegularTopping extends Topping{

    //Constructor
    public RegularTopping(String type) {
        super(type);
    }

    //Method to calculate the price of the topping. The size of the sandwich is provided as the argument to determine the price of the topping
    @Override
    public double calculatePrice(int size) {
        //The Regular Toppings are free
        return 0;
    }
}
