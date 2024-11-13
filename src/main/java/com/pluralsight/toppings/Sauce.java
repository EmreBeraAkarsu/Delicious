package com.pluralsight.toppings;

//Sauce topping class that is a child class of the Topping class
public class Sauce extends Topping{

    //Constructor
    public Sauce(String type) {
        super(type);
    }

    //Method to calculate the price of the topping. The size of the sandwich is provided as the argument to determine the price of the topping
    @Override
    public double calculatePrice(int size) {
        //The Sauces are free
        return 0;
    }

}
