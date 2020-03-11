package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.data.SomeDataService;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int sum(int[] data) {
        int sum = 0;

        for (int value : data) {
            sum += value;
        }

        return sum;
    }

    public int sumUsingDataService() {
        int[] data = someDataService.retrieveAllData();
        int sum = 0;

        for (int value : data) {
            sum += value;
        }

        return sum;
    }
}
