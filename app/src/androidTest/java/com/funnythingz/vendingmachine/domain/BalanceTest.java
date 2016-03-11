package com.funnythingz.vendingmachine.domain;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BalanceTest extends TestCase {

    private Balance balance;

    @Before
    public void setUp() throws Exception {
        balance = new Balance(1000);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetValue() throws Exception {
        assertEquals(balance.getValue(), 1000);
    }
}