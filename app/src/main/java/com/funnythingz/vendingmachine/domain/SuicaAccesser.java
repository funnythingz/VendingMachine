package com.funnythingz.vendingmachine.domain;

public class SuicaAccesser {

    public static Balance readBalance(Suica suica) {
        if (suica != null && suica instanceof Suica) {
            return suica.getBalance();
        }

        return null;
    }

    public static void updateBalance(Suica suica, Balance balance) {
        if (suica != null && suica instanceof Suica) {
            suica.updateBalance(balance);
        }
    }
}
