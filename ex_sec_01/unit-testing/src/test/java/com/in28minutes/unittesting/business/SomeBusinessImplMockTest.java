package com.in28minutes.unittesting.business;

import com.in28minutes.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {

    @InjectMocks
    SomeBusinessImpl business;

    @Mock
    SomeDataService someDataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSumUsingDataService_oneValue() {
        when(someDataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
        int expectedResult = 5;
        assertEquals(expectedResult, business.calculateSumUsingDataService());
    }

}