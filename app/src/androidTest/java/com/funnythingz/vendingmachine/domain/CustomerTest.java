package com.funnythingz.vendingmachine.domain;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest extends TestCase {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer(new CustomerId("c1"), new Suica(new SuicaId("s1"), new Balance(1000)));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetSuica() throws Exception {
        assertEquals(customer.getSuica() instanceof Suica, true);
    }

    @Test
    public void testEquals() throws Exception {
        Customer c1 = new Customer(new CustomerId("c1"), new Suica(new SuicaId("s1"), new Balance(1000)));
        Customer c2 = new Customer(new CustomerId("c2"), null);
        assertEquals(customer.equals(c1), true);
        assertEquals(customer.equals(c2), false);
    }

    @Test
    public void testGetId() throws Exception {
        CustomerId c1 = new CustomerId("c1");
        CustomerId c2 = new CustomerId("c2");
        assertEquals(customer.getId(), c1);
        assertEquals(customer.getId().equals(c2), false);
    }
}