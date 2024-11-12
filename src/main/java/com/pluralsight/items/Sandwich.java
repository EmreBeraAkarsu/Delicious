package com.pluralsight.items;

import com.pluralsight.toppings.*;

import javax.security.sasl.SaslClient;
import java.util.List;

public class Sandwich implements Item{

    private String bread;
    private int size;
    private List<Topping> toppings;
    private boolean isToasted;

    public Sandwich(String bread, int size, List<Topping> toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }

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

    @Override
    public double getPrice() {
        return 0;
    }
}