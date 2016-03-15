package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

@RunWith(AndroidJUnit4.class)
public class SuicaTest extends TestCase {

    private Suica suica;

    @Before
    public void setUp() throws Exception {
        suica = new Suica(new SuicaId("s1"), new Balance(1000));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetId() throws Exception {
        Assert.assertEquals(suica.getId().getValue(), "s1");
    }

    @Test
    public void testGetBalance() throws Exception {
        Assert.assertThat(suica.getBalance(), is(instanceOf(Balance.class)));
    }

    @Test
    public void testEquals() throws Exception {
        Suica that = new Suica(new SuicaId("s2"), new Balance(1000));
        Assert.assertFalse(suica.equals(that));
    }

    @Test
    public void testUpdateBalance() throws Exception {
        suica.updateBalance(new Balance(1500));
        Assert.assertEquals(suica.getBalance().getValue(), 1500);
    }
}