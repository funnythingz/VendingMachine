package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PriceTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetValue() throws Exception {
        Price p100 = new Price(100);
        Price p200 = new Price(200);
        Assert.assertFalse(p100.equals(p200));
        Assert.assertEquals(p100.getValue(), 100);
        Assert.assertEquals(p200.getValue(), 200);
    }
}