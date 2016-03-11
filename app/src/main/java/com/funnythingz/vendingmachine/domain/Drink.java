package com.funnythingz.vendingmachine.domain;

public class Drink {

    private DrinkName drinkName;

    public Drink(DrinkName drinkName) {
        this.drinkName = drinkName;
    }

    public DrinkName getDrinkName() {
        return drinkName;
    }
}
