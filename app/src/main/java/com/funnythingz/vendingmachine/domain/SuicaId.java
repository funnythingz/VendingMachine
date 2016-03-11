package com.funnythingz.vendingmachine.domain;

import com.funnythingz.vendingmachine.ddd.AbstractIdentity;

public class SuicaId extends AbstractIdentity<String> {

    public SuicaId(String value) {
        super(value);
    }
}
