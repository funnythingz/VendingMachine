package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class FantaTest extends TestCase {

    @Test
    public void testGetDrinkName() throws Exception {
        Fanta fanta = new Fanta();
        Assert.assertEquals(fanta.getDrinkName().getValue(), "ファンタ");
    }
}