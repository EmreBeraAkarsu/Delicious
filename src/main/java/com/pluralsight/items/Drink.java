package com.pluralsight.items;

//Drink class for creating the chip objects to be stored in the order. This class implements the Item interface.
public class Drink implements IPrice {

    //The size and the flavor of the drink stored in these variables
    private String size;
    private String flavor;


    //Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    //Getters. No setters necessary since they are given at the consturctor
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    //Method for getting the price
    @Override
    public double getPrice() {
        //Return the corresponding price for the size of the drink entered
        switch (size) {
            case "S":
                return 2;
            case "M":
                return 2.5;
            case "L":
                return 3;
            default:
                return 0;
        }
    }

    //Method to convert the data to a string
    @Override
    public String toString() {
        return "Drink: " + flavor + " (" + size + ") - Price: $" + getPrice();
    }
}
