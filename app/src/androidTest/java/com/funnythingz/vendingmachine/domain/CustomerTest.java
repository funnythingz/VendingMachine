package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
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
        Assert.assertTrue(customer.getSuica() instanceof Suica);
    }

    @Test
    public void testEquals() throws Exception {
        Customer c1 = new Customer(new CustomerId("c1"), new Suica(new SuicaId("s1"), new Balance(1000)));
        Customer c2 = new Customer(new CustomerId("c2"), null);
        Assert.assertTrue(customer.equals(c1));
        Assert.assertFalse(customer.equals(c2));
    }

    @Test
    public void testGetId() throws Exception {
        CustomerId c1 = new CustomerId("c1");
        CustomerId c2 = new CustomerId("c2");
        Assert.assertEquals(customer.getId(), c1);
        Assert.assertFalse(customer.getId().equals(c2));
    }
}