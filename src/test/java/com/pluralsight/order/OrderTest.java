package com.pluralsight.order;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Sandwich;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addSandwiches_Add2SandwichesToAnOrder_TheAddedSandwichesAreShownInTheOrderSandwichesArrayList() {
        //Arrange
        Order order = new Order();
        Sandwich sandwich1 = new Sandwich("white", 8, true);
        Sandwich sandwich2 = new Sandwich("rye", 4, false);

        List<Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(sandwich1);
        sandwiches.add(sandwich2);

        //Act
        order.addSandwiches(sandwich1);
        order.addSandwiches(sandwich2);

        //Assert
        assertEquals(sandwiches,order.getSandwiches());
    }

    @Test
    void addChip_Add2ChipsToAnOrder_TheOrderChipsMatchTheAddedChips() {
        //Arrange
        Order order = new Order();
        Chip chip1 = new Chip("BBQ");
        Chip chip2 = new Chip("Salt and Vinegar");

        List<Chip> chips = new ArrayList<>();
        chips.add(chip1);
        chips.add(chip2);

        //Act
        order.addChip(chip1);
        order.addChip(chip2);

        //Assert
        assertEquals(chips, order.getChips());
    }



    @Test
    void getTotalPrice() {
        //Arrange
        Order order = new Order();

        Chip chip1 = new Chip("BBQ");
        Chip chip2 = new Chip("Salt and Vinegar");

        Sandwich sandwich1 = new Sandwich("white", 8, true);
        Sandwich sandwich2 = new Sandwich("rye", 4, false);

        order.addChip(chip1);
        order.addChip(chip2);

        order.addSandwiches(sandwich1);
        order.addSandwiches(sandwich2);

        //Act
        double totalPrice = order.getTotalPrice();


        //Assert
        assertEquals(15.5, totalPrice);
    }
}