package com.pluralsight.items;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void getPrice_CheckThePriceOfASmallDrink_PriceIs2() {
        //Arrange
        Drink drink = new Drink("s", "pepsi");

        //Act
        double drinkPrice = drink.getPrice();

        //Assert
        assertEquals(2, drinkPrice);

    }
}
