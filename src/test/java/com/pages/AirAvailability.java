package com.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.enums.Wait;
import com.setup.DriverManager;

import io.qameta.allure.Step;

public class AirAvailability extends BasePage{
	
	public AirAvailability() {
//		super(driver);
//		this.driver = driver;
		PageFactory.initElements(DriverManager.getDriver(), this);
		// TODO Auto-generated constructor stub
	}
	public By firstprice() {
		return By.xpath("(//button[text()='Book']/../../../div[3]//div/p)[1]");
	}
	
	@Step("getText")
	public void validateFirstResult(Wait wait, String message)
	{
		click(firstprice(),wait,message);
		assertTrue(readText(firstprice(),wait).length()>0);
		System.out.println(readText(firstprice(),wait));
		
	}

}
