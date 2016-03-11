package com.funnythingz.vendingmachine.domain;

import com.funnythingz.vendingmachine.ddd.AbstractEntity;

public class Customer extends AbstractEntity<CustomerId> {

    private Suica suica;

    public Customer(CustomerId identity, Suica suica) {
        super(identity);
        this.suica = suica;
    }

    public Suica getSuica() {
        return suica;
    }
}
