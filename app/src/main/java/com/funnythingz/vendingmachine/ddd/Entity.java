package com.funnythingz.vendingmachine.ddd;

import java.io.Serializable;

public interface Entity<ID extends Identity<?>> extends Serializable {

    @Override
    boolean equals(Object that);

    ID getId();
}
