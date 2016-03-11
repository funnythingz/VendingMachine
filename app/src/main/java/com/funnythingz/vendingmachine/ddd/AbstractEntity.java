package com.funnythingz.vendingmachine.ddd;

@SuppressWarnings("serial")
public class AbstractEntity<ID extends Identity<?>> implements Entity<ID> {

    private ID identity;

    public AbstractEntity(ID identity) {
        this.identity = identity;
    }

    @Override
    public boolean equals(Object that) {
        return identity.equals(((AbstractEntity<ID>) that).getId());
    }

    @Override
    public ID getId() {
        return identity;
    }
}
