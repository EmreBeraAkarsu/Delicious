package com.pluralsight.items;

import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.RegularTopping;
import com.pluralsight.toppings.Sauce;

import javax.security.sasl.SaslClient;
import java.util.List;

public class Sandwich implements Item{

    private String bread;
    private int size;
    private List<Meat> meats;
    private List<Sauce> sauces;
    private List<RegularTopping> regularToppings;
    private List<Cheese> cheeses;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Meat> meats, List<Sauce> sauces, List<RegularTopping> regularToppings, List<Cheese> cheeses, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.meats = meats;
        this.sauces = sauces;
        this.regularToppings = regularToppings;
        this.cheeses = cheeses;
        this.isToasted = isToasted;
    }


    public String getBread() {
        return bread;
    }

    public int getSize() {
        return size;
    }

    public List<Meat> getMeats() {
        return meats;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }

    public List<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

    public boolean isToasted() {
        return isToasted;
    }
}
