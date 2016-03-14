package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class PocaliTest {

    @Test
    public void testGetDrinkName() throws Exception {
        Pocali pocali = new Pocali();
        Assert.assertEquals(pocali.getDrinkName().getValue(), "ポカリ");
    }
}