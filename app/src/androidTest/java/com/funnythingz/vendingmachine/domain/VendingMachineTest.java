package com.funnythingz.vendingmachine.domain;

import android.support.test.runner.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(AndroidJUnit4.class)
public class VendingMachineTest extends TestCase {

    private VendingMachine vendingMachine;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        vendingMachine = new VendingMachine();
        customer = new Customer(new CustomerId("c1"), new Suica(new SuicaId("s1"), new Balance(1000)));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSelectDrinkButton() throws Exception {
        vendingMachine.selectDrinkButton(DrinkMenu.Cola);
        Assert.assertThat(vendingMachine.hasSelectDrink(), is(instanceOf(Cola.class)));
        vendingMachine.selectDrinkButton(DrinkMenu.Soda);
        Assert.assertThat(vendingMachine.hasSelectDrink(), is(instanceOf(Soda.class)));
        vendingMachine.selectDrinkButton(DrinkMenu.Fanta);
        Assert.assertThat(vendingMachine.hasSelectDrink(), is(instanceOf(Fanta.class)));
        vendingMachine.selectDrinkButton(DrinkMenu.Pocali);
        Assert.assertThat(vendingMachine.hasSelectDrink(), is(instanceOf(Pocali.class)));
    }

    @Test
    public void testTouchSuica() throws Exception {
        // タッチする前はSuicaの残高が1000円
        Assert.assertEquals(customer.getSuica().getBalance().getValue(), 1000);

        // ドリンクを選んでいない状態だとSuicaをタッチしても何も起こらない
        vendingMachine.touchSuica(customer.getSuica());
        Assert.assertEquals(customer.getSuica().getBalance().getValue(), 1000);

        // コーラを選んでSuicaをタッチすると残高から100円引かれる
        vendingMachine.selectDrinkButton(DrinkMenu.Cola);
        vendingMachine.touchSuica(customer.getSuica());
        Assert.assertEquals(customer.getSuica().getBalance().getValue(), 900);

        // 購入したあとにドリンクを選んでいない状態でタッチしても何も起こらない
        vendingMachine.touchSuica(customer.getSuica());
        Assert.assertEquals(customer.getSuica().getBalance().getValue(), 900);
    }

    @Test
    public void testDrinkOutlet() throws Exception {

        // ドリンクを買っていない状態だと取り出し口には何もない
        Assert.assertThat(vendingMachine.drinkOutlet(), nullValue());

        // ファンタを選んでSuicaをタッチする
        vendingMachine.selectDrinkButton(DrinkMenu.Fanta);
        // Suicaの残高から100円引かれて決済が完了する
        vendingMachine.touchSuica(customer.getSuica());

        // 購入したファンタを取り出し口から受け取る
        Fanta fanta = (Fanta) vendingMachine.drinkOutlet();
        Assert.assertThat(fanta, is(instanceOf(Fanta.class)));
        Assert.assertEquals(fanta.getDrinkName().getValue(), "ファンタ");
    }
}