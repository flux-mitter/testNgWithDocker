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
	public void validateHotelIsSelected() {
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
	public void validateOfferesIsSelected2() {
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

}
