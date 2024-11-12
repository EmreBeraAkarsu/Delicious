package com.pluralsight.order;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;

import java.util.List;

public class Order {

    private List<Sandwich> sandwiches;
    private List<Chip> chips;
    private List<Drink> drinks;

    public Order(List<Sandwich> sandwiches, List<Chip> chips, List<Drink> drinks) {
        this.sandwiches = sandwiches;
        this.chips = chips;
        this.drinks = drinks;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void setChips(List<Chip> chips) {
        this.chips = chips;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void checkout(){

        
    }
}
