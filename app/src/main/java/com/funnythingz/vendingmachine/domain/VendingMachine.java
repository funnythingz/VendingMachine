package com.funnythingz.vendingmachine.domain;

public class VendingMachine {

    private final Price price;

    private Balance suicaBalance;
    private Drink selectDrink;
    private boolean isBought;

    public VendingMachine() {
        this.price = new Price(100);
        clearPurchased();
    }

    public Drink selectDrinkButton(DrinkMenu drinkMenu) {
        switch (drinkMenu) {
            case Cola:
                return new Cola();
            case Fanta:
                return new Fanta();
            case Soda:
                return new Soda();
            case Pocali:
                return new Pocali();
        }

        return null;
    }

    public void touchSuica(Suica suica) {
        if (isSelectDrink()) {
            readSuicaBalance(suica);
            if (isReadedSuicaBalance()) {
                updateSuicaBalance(suica);
            }
        }

    }

    private boolean readSuicaBalance(Suica suica) {
        suicaBalance = SuicaAccesser.readBalance(suica);
        return (suicaBalance != null);
    }

    private void updateSuicaBalance(Suica suica) {
        if (calcBalance() != null) {
            SuicaAccesser.updateBalance(suica, calcBalance());
            clearSuicaBalance();
        }
    }

    private Balance calcBalance() {
        int result = suicaBalance.getValue() - price.getValue();
        if (result >= 0) {
            purchased();
            new Balance(result);
        }

        return null;
    }

    private boolean isSelectDrink() {
        return (selectDrink != null && selectDrink instanceof Drink);
    }

    private boolean isReadedSuicaBalance() {
        return (suicaBalance != null && suicaBalance instanceof Balance);
    }

    private void purchased() {
        isBought = true;
    }

    private void clearPurchased() {
        isBought = false;
    }

    private void clearSelectDrink() {
        selectDrink = null;
    }

    private void clearSuicaBalance() {
        suicaBalance = null;
    }

    public Drink drinkOutlet() {
        if (isBought) {
            Drink outDrink = selectDrink;
            clearSelectDrink();
            clearSuicaBalance();
            clearPurchased();
            return outDrink;
        }

        return null;
    }
}
