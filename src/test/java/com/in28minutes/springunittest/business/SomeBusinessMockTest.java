package com.in28minutes.springunittest.business;

import com.in28minutes.springunittest.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    private SomeBusinessImpl business;

    @Mock
    private SomeDataService dataServiceMock;

    @Test
    public void sumUsingDataService_basic() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});

        int actualResult = business.sumUsingDataService();
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sumUsingDataService_empty() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});

        int actualResult = business.sumUsingDataService();

        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void sumUsingDataService_oneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{3});

        int actualResult = business.sumUsingDataService();

        int expectedResult = 3;

        assertEquals(expectedResult, actualResult);
    }

}