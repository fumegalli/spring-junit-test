package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{};
    }
}

class SomeDataServiceOneValueStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{3};
    }
}

class SomeBusinessStubTest {

    @Test
    public void sumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.sumUsingDataService();

        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceEmptyStub());

        int actualResult = business.sumUsingDataService();

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sumUsingDataService_oneValue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceOneValueStub());

        int actualResult = business.sumUsingDataService();

        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

}