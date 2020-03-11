package com.in28minutes.springunittest.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessTest {

    @Test
    public void sum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.sum(new int[]{1, 2, 3});

        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sum_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.sum(new int[]{});

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sum_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.sum(new int[]{3});

        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

}