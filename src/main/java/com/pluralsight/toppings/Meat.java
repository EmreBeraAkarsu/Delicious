package com.pluralsight.toppings;

//Meat topping class that is a child class of the Topping class
public class Meat extends Topping{
    //Constructor
    public Meat(String type) {
        super(type);
    }

    //Method to calculate the price of the topping. The size of the sandwich is provided as the argument to determine the price of the topping
    @Override
    public double calculatePrice(int size) {
        //The size is divided to 4. Inside the parenthesis results in 1-2-3 respectively to the sandwich sizes 4-8-12
        //The expected price for the sizes respectively should be 1-2-3
        return 1 * (size / 4);
    }
}
