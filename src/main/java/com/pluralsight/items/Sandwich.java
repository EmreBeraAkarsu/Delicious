package com.pluralsight.items;

import com.pluralsight.toppings.*;


import java.util.List;

//Sandwich class for creating the chip objects to be stored in the order. This class implements the Item interface.
public class Sandwich implements Item {

    //The details of the Sandwich is stored in the variables below
    private String bread;
    private int size;
    private List<Topping> toppings;
    private boolean isToasted;

    //Constructor
    public Sandwich(String bread, int size, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

    //Getters. No setters are necessary since they are given at the constructor
    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    //Method to calculate the price of the sandwich
    @Override
    public double getPrice() {
        //The variable for the total is initialized at 0
        double totalSandwichPrice = 0;

        //Add the base price depending on the size of the sandwich
        if (size == 4){
            totalSandwichPrice += 5.5;
        } else if (size == 8) {
            totalSandwichPrice += 7;
        }else {
            totalSandwichPrice += 8.5;
        }

        //Iterate through all the toppings, call each toppings' calculatePrice() method to get the corresponding price, add the price to the total
        for (Topping topping : toppings) {
            totalSandwichPrice += topping.calculatePrice(size);
        }

        //Return the total value
        return totalSandwichPrice;
    }

    //Method to convert the data to a string
    @Override
    public String toString() {
        return "Sandwich{" +
                "bread='" + bread + '\'' +
                ", size=" + size +
                ", toppings=" + toppings +
                ", isToasted=" + isToasted +
                '}';
    }
}
