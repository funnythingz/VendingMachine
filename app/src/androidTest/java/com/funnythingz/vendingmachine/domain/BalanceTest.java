package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BalanceTest extends TestCase {

    @Test
    public void testGetValue() throws Exception {
        Balance balance = new Balance(1000);
        Assert.assertEquals(balance.getValue(), 1000);
    }
}