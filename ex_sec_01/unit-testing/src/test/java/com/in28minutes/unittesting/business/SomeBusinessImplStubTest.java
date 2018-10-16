package com.in28minutes.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.in28minutes.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] {1,2,3};
	}
	
}

public class SomeBusinessImplStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSum(new int[] { 1, 2, 3 });
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

}