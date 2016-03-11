package com.funnythingz.vendingmachine.domain;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ColaTest extends TestCase {

    private Cola cola;

    @Before
    public void setUp() throws Exception {
        cola = new Cola();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetDrinkName() throws Exception {
        assertEquals(cola.getDrinkName().getValue(), "コーラ");
    }
}