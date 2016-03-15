package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(AndroidJUnit4.class)
public class SuicaAccesserTest extends TestCase {

    private Suica suica;

    @Before
    public void setUp() throws Exception {
        suica = new Suica(new SuicaId("s1"), new Balance(5000));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testReadBalance() throws Exception {
        Balance readedBalance = SuicaAccesser.readBalance(suica);
        Assert.assertThat(readedBalance, is(equalTo(suica.getBalance())));
        Assert.assertEquals(readedBalance.getValue(), suica.getBalance().getValue());
        Assert.assertThat(SuicaAccesser.readBalance(null), nullValue());
    }

    @Test
    public void testUpdateBalance() throws Exception {
        SuicaAccesser.updateBalance(suica, new Balance(10000));
        Assert.assertEquals(suica.getBalance().getValue(), 10000);
        Assert.assertNotEquals(suica.getBalance().getValue(), 5000);
    }
}