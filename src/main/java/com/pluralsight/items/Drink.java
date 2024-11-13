package com.pluralsight.items;

//Drink class for creating the chip objects to be stored in the order. This class implements the Item interface.
public class Drink implements Item{

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
        if (size.equalsIgnoreCase("s")){
            return 2;
        } else if (size.equalsIgnoreCase("m")) {
            return 2.5;
        }else {
            return 3;
        }
    }

    //Method to convert the data to a string
    @Override
    public String toString() {
        return "Drink: " +
                "size='" + size + '\'' +
                ", flavor='" + flavor + '\'';
    }
}
