package com.pages;

import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.config.UtilityMethods;
import com.enums.Wait;
import com.report.runConfig.ExtentLogger;
import com.setup.DriverManager;

import io.qameta.allure.Step;

public class HomePage extends BasePage {

//	public HomePage(WebDriver driver) {
////		super(driver);
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		// TODO Auto-generated constructor stub
//	}
//	
	public HomePage() {
//		super(driver);
//		this.driver = driver;
		PageFactory.initElements(DriverManager.getDriver(), this);
		// TODO Auto-generated constructor stub
	}

//	@CacheLookup
//	@FindBy(name="q")
//	private WebElement test;

	public By close() {
		return By.xpath(
				"//button/span[contains(text(),'Get OTP')]/../../../../..//div[contains(@style,'border-radius: 14px;')]");
	}

	// @Step("Sub category clicked")//this is for heroku app
	public By selectSubSategory(String subCategory) {
//		return By.xpath("//a/div[text()='"+subCategory+"']");
		return By.xpath("//li/a[contains(text(),'" + subCategory + "')]");
	}

	private By flights() {
		return By.xpath("//a/div[contains(text(),'Flights')]");
	}

	private By regularFare() {
		return By.xpath("//div/div[contains(text(),'Regular fare')]");
	}

	private By fromCity()
	{
		return By.xpath("//input[@placeholder='Where from?']");
	}
	
	
	private By cityCode(String cityCode)
	{
		return By.xpath("//div/div[contains(text(),'"+cityCode+"')]");
	}
	private By toCity()
	{
		return By.xpath("//input[@placeholder='Where to?']");
	}
	
	private By dateOption()
	{
		return By.xpath("//div/button/div/preceding-sibling::*");
	}
	
	private By datePicker(String month, String day)
	{
		return By.xpath("//div[contains(text(),'"+month+" ')]/../following-sibling::div[contains(@class,'DayPicker-Body')]//div[text()='"+day+"']");
	}
	
	private By searchFlights()
	{
		return By.xpath("//div/span[contains(text(),'Search flights')]");
	}
	

	public void closePopup(Wait wait, String message) {
		click(close(), Wait.CLICKABLE, message);
	}

	@Step("Sub category clicked {0}")
	public void selectSubcategory(String subCategory, Wait wait, String message) {
		click(selectSubSategory(subCategory), wait, message);
	}

	@Step("Negative Testing {0}")
	public void negative(String subCategory, Wait wait, String message) {
		ExtentLogger.pass("Checking elelment",true);
		// Assert.assertEquals(false, isDisplayed(selectSubSategory(subCategory),
		// Wait.NONE));
		// Assert.assertEquals(false,
		// DriverManager.getDriver().findElement(selectSubSategory(subCategory)).isDisplayed());
		if (DriverManager.getDriver().findElements(selectSubSategory(subCategory)).size() > 0) {
			assertTrue(true);
			ExtentLogger.pass(subCategory + " Element present",true);
		} else {
			ExtentLogger.fail(subCategory + " Element not present",true);
			assertTrue(false);

		}

	}
	
	@Step("select from {2} and To {3}")
	public void selectFromTo(Wait wait, String message,String from, String to) throws InterruptedException
	{
		click(flights(), wait, "Clicked on Flights");
		click(regularFare() , wait, "Clicked on Regular fare");
		writeText(fromCity(), wait, from.toUpperCase());
		Thread.sleep(2000);
		click(cityCode(from.toUpperCase()), wait, "Selected "+from);
		writeText(toCity(), wait, to.toUpperCase());
		Thread.sleep(2000);
		click(cityCode(to.toUpperCase()), wait, "Selected "+to);
	}
	
	@Step("Select date {0}")
	public void selectDate(Wait wait, String message,int dateDifference)
	{
		click(dateOption(), wait, "clicked on date field");
		click(datePicker(UtilityMethods.monthDay(20).get(0), UtilityMethods.monthDay(20).get(1)), wait, message+"month :"+UtilityMethods.monthDay(20).get(0)+"  Day :"+UtilityMethods.monthDay(20).get(0));
	}
	
	@Step("Search flights")
	public void clickSearchFlights(Wait wait, String message)
	{
		click(searchFlights(),wait,message);
	}
	
	

}
