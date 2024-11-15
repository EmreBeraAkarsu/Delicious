package com.pluralsight.items;

import static org.junit.jupiter.api.Assertions.*;

class ChipTest {

    @org.junit.jupiter.api.Test
    void getPrice_CheckthePriceOfTheChips_ThePricceIsOneFifty() {

        //Arrange
        Chip chip = new Chip("BBQ");

        //Act
        double chipPrice = chip.getPrice();

        //Assert
        assertEquals(1.5, chipPrice);

    }
}