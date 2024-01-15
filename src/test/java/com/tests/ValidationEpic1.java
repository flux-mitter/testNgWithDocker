package com.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.custom.annotations.FrameworkAnnotations;
import com.enums.ExecutionType;
import com.enums.Wait;
import com.report.runConfig.Retry;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import jdk.jfr.Enabled;

//@Listeners({com.report.runConfig.AllureTestListener.class})
//@Test(retryAnalyzer = com.report.runConfig.Retry.class)
public class ValidationEpic1 extends BaseTest {

	
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Test()
	@Epic(value = "TV001")
	//@Description("Testing Link Broken 1")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void validateBrokenIsSelected() {
		homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
	}
	
	@Test()
	@Epic(value = "TV001")
	@Description("Testing Link Checkboxes 1")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.BLOCKER)
	public void validateOfferesIsSelected() {
		homePage.selectSubcategory("Checkboxes",Wait.CLICKABLE,"Clicked on Checkboxes");
	}
	
	@Test(priority = 3)
//	@Test(priority = 3,retryAnalyzer = Retry.class)
	@Epic(value = "TV0012")
	@Description("Testing Link Checkboxes negative")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.MINOR)
	public void validateOfferesIsSelectedNegative() {
		homePage.negative("Checkboxes2",Wait.CLICKABLE,"neagtive step");
	}
	
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Test(priority = 4)
	@Epic(value = "TV001")
	@Description("Testing Link Broken 2")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void validateHotelIsSelected2() {
		homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
	}
	
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "TV001")
	@Description("Search Flights")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchFlights() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		homePage.selectFromTo(Wait.PRESENCE, "select from to", "CCU", "DEL");
		homePage.selectDate(Wait.PRESENCE, "Selected date from calender ", 20);
		homePage.clickSearchFlights(Wait.CLICKABLE, "Clicked on Search ");
		airAvailability.validateFirstResult(Wait.PRESENCE, "validating 1st price displayed on page");
	}
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "TV001")
	@Description("Search Flights 2")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchFlights2() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		homePage.selectFromTo(Wait.PRESENCE, "select from to", "CCU", "DEL");
		homePage.selectDate(Wait.PRESENCE, "Selected date from calender ", 20);
		homePage.clickSearchFlights(Wait.CLICKABLE, "Clicked on Search ");
		airAvailability.validateFirstResult(Wait.PRESENCE, "validating 1st price displayed on page");
	}
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "TV001")
	@Description("Search Flights 3")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchFlights3() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		homePage.selectFromTo(Wait.PRESENCE, "select from to", "CCU", "DEL");
		homePage.selectDate(Wait.PRESENCE, "Selected date from calender ", 20);
		homePage.clickSearchFlights(Wait.CLICKABLE, "Clicked on Search ");
		airAvailability.validateFirstResult(Wait.PRESENCE, "validating 1st price displayed on page");
	}
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "TV001")
	@Description("Search Flights 4")
	@Story("verify main page links")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchFlights4() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		homePage.selectFromTo(Wait.PRESENCE, "select from to", "CCU", "DEL");
		homePage.selectDate(Wait.PRESENCE, "Selected date from calender ", 20);
		homePage.clickSearchFlights(Wait.CLICKABLE, "Clicked on Search ");
		airAvailability.validateFirstResult(Wait.PRESENCE, "validating 1st price displayed on page");
	}
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "AZ001")
	@Description("Search Product in Amazon")
	@Story("Search product")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProduct() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		amazonHomePage.searchProduct(Wait.PRESENCE, "iPhone 14", "Search Iphone 14");
		productSearchResult.productDisplaySort(Wait.PRESENCE, "High to Low");
		productSearchResult.validateProductResultSorting(Wait.NONE, "iPhone 14");
		
	}
	
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "AZ002")
	@Description("Search Product in Amazon2")
	@Story("Search product")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProduct_2nd() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		amazonHomePage.searchProduct(Wait.PRESENCE, "iPhone 14", "Search Iphone 14");
		productSearchResult.productDisplaySort(Wait.PRESENCE, "High to Low");
		productSearchResult.validateProductResultSorting(Wait.NONE, "iPhone 14");
		
	}
	@Test
	@FrameworkAnnotations(author = { "Preetam" }, executionType = { ExecutionType.REGRESSION, ExecutionType.SMOKE })
	@Epic(value = "AZ003")
	@Description("Search Product in Amazon3")
	@Story("Search product")
	@Feature("Broken")
	@Severity(SeverityLevel.CRITICAL)
	public void searchProduct_3rd() throws InterruptedException {
		//homePage.selectSubcategory("Broken",Wait.CLICKABLE,"Clicked on Broken");
		amazonHomePage.searchProduct(Wait.PRESENCE, "iPhone 14", "Search Iphone 14");
		//productSearchResult.productDisplaySort(Wait.PRESENCE, "High to Low");
		//productSearchResult.validateProductResultSorting(Wait.NONE, "iPhone 14");
		
	}

}
