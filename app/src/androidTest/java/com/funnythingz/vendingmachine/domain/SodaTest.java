package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SodaTest {

    @Test
    public void testGetDrinkName() throws Exception {
        Soda soda = new Soda();
        Assert.assertEquals(soda.getDrinkName().getValue(), "ソーダ");
    }
}