package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int sum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int sumUsingDataService() {
        int[] data = someDataService.retrieveAllData();

        return sum(data);
    }
}
