package com.pluralsight.toppings;

//Cheese topping class that is a child class of the Topping class
public class Cheese extends Topping{
    //Constructor
    public Cheese(String type) {
        super(type);
    }

    //Method to calculate the price of the topping. The size of the sandwich is provided as the argument to determine the price of the topping
    @Override
    public double calculatePrice(int size) {
        //The size is divided to 4. Inside the parenthesis results in 1-2-3 respectively to the sandwich sizes 4-8-12
        //The expected price for the sizes respectively should be .75-1.5-2.25
        return .75 * (size / 4);
    }
}
