package com.pluralsight.order;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;

import java.util.ArrayList;
import java.util.List;

// The Order class combines all the items selected by the customer into a single class
public class Order {

    // Lists of items are stored inside lists
    private List<Sandwich> sandwiches;
    private List<Chip> chips;
    private List<Drink> drinks;

    //Constructor
    public Order() {
        this.sandwiches = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    //Getters and adders
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

    // Total price of the order calculated
    public double getTotalPrice(){

        //Total initialized to 0
        double totalPriceOfTheOrder = 0;

        // Iterate through the sandwiches list, get the price, and add to total
        for (Sandwich sandwich : sandwiches) {
            totalPriceOfTheOrder += sandwich.getPrice();
        }
        // Iterate through the chips list, get the price, and add to total
        for (Chip chip : chips) {
            totalPriceOfTheOrder += chip.getPrice();
        }

        // Iterate through the drinks list, get the price, and add to total
        for (Drink drink : drinks) {
            totalPriceOfTheOrder += drink.getPrice();
        }

        // Return the total price
        return totalPriceOfTheOrder;
    }

    //
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
