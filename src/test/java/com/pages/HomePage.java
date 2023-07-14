package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.enums.Wait;
import com.setup.DriverManager;

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
	
	public By close()
	{
		return By.xpath("//button/span[contains(text(),'Get OTP')]/../../../../..//div[contains(@style,'border-radius: 14px;')]");
	}
	
	public By selectSubSategory(String subCategory)
	{
		return By.xpath("//a/div[text()='"+subCategory+"']");
	}
	
	public void closePopup()
	{
		click(close(),Wait.CLICKABLE);
	}
	
	public void selectSubcategory(String subCategory)
	{
		click(selectSubSategory(subCategory), Wait.CLICKABLE);
	}
	
}
