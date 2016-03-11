package com.funnythingz.vendingmachine.domain;

import com.funnythingz.vendingmachine.ddd.AbstractEntity;

public class Suica extends AbstractEntity<SuicaId> {

    private Balance balance;

    public Suica(SuicaId suicaId, Balance balance) {
        super(suicaId);
        this.balance = balance;
    }

    public void updateBalance(Balance balance) {
        if (this.balance.equals(balance)) {
            return;
        }

        this.balance = balance;
    }

    public Balance getBalance() {
        return balance;
    }
}
