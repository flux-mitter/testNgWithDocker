package com.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.enums.Wait;
import com.report.runConfig.ExtentLogger;
import com.setup.DriverManager;

import io.qameta.allure.Step;

public class HomePage extends BasePage
{

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
	
	public By close()
	{
		return By.xpath("//button/span[contains(text(),'Get OTP')]/../../../../..//div[contains(@style,'border-radius: 14px;')]");
	}
	//@Step("Sub category clicked")
	public By selectSubSategory(String subCategory)
	{
//		return By.xpath("//a/div[text()='"+subCategory+"']");
		return By.xpath("//li/a[contains(text(),'"+subCategory+"')]");
	}
	
	public void closePopup(Wait wait, String message)
	{
		click(close(),Wait.CLICKABLE,message);
	}
	@Step("Sub category clicked {0}")
	public void selectSubcategory(String subCategory, Wait wait, String message)
	{
		click(selectSubSategory(subCategory), wait,message);
	}
	@Step("Negative Testing {0}")
	public void negative(String subCategory,Wait wait, String message)
	{
		ExtentLogger.pass("Checking elelment");
		//Assert.assertEquals(false, isDisplayed(selectSubSategory(subCategory),  Wait.NONE));
		//Assert.assertEquals(false, DriverManager.getDriver().findElement(selectSubSategory(subCategory)).isDisplayed());
		if (DriverManager.getDriver().findElements(selectSubSategory(subCategory)).size()>0) {
			assertTrue(true);
			ExtentLogger.pass(subCategory+ " Element present");
		}
		else
		{
			ExtentLogger.fail(subCategory+ " Element not present");
			assertTrue(false);
			
		}
		
	}
	
}
