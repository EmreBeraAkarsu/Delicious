package com.pluralsight.order;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Sandwich> sandwiches;
    private List<Chip> chips;
    private List<Drink> drinks;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwiches(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void addDrinks(Drink drink) {
        drinks.add(drink);
    }

    public double getTotalPrice(){
        double totalPriceOfTheOrder = 0;

        for (Sandwich sandwich : sandwiches) {
            totalPriceOfTheOrder += sandwich.getPrice();
        }

        for (Chip chip : chips) {
            totalPriceOfTheOrder += chip.getPrice();
        }

        for (Drink drink : drinks) {
            totalPriceOfTheOrder += drink.getPrice();
        }

        return totalPriceOfTheOrder;
    }

    public void checkout(){

        OrderFileManager orderFileManager = new OrderFileManager();

        orderFileManager.writeOrderToFile(orderFileManager.createReceipt(this));

    }

    @Override
    public String toString() {
        return "sandwiches=" + sandwiches +
                ", chips=" + chips +
                ", drinks=" + drinks +
                "Total Price: " + this.getTotalPrice();
    }
}
