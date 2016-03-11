package com.funnythingz.vendingmachine.domain;

import com.funnythingz.vendingmachine.ddd.AbstractIdentity;

public class CustomerId extends AbstractIdentity<String> {

    public CustomerId(String value) {
        super(value);
    }
}
