package com.funnythingz.vendingmachine.ddd;

public class AbstractIdentity<T> implements Identity<T> {

    protected final T value;

    protected AbstractIdentity(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        AbstractIdentity<T> that = (AbstractIdentity<T>) o;
        return value.equals(that.value);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
