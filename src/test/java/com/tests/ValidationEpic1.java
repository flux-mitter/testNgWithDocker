package com.tests;

import org.testng.annotations.Test;
import com.custom.annotations.FrameworkAnnotations;
import com.enums.ExecutionType;

public class ClearTripHomePageTestCases extends BaseTest {

	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	
	@Test
	public void validateHotelIsSelected() {
		System.out.println("Help");
		homePage.selectSubcategory("Hotels");
	}
	
	@Test
	public void validateOfferesIsSelected() {
		System.out.println("Help");
		homePage.selectSubcategory("Offers");
	}

}
