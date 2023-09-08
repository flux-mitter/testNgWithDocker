package com.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.enums.Wait;
import com.setup.DriverManager;

import io.qameta.allure.Step;

public class AmazonHomePage extends BasePage{
	
	public AmazonHomePage() {
//		super(driver);
//		this.driver = driver;
		PageFactory.initElements(DriverManager.getDriver(), this);
		// TODO Auto-generated constructor stub
	}
	private By searchBox() {
		return By.xpath("//div/input[@type='text' and @id='twotabsearchtextbox']");
	}
	private By searchButton() {
		return By.xpath("//span/input[@type='submit']");
	}
	
	@Step("getText")
	public void searchProduct(Wait wait, String product, String message)
	{
		writeText(searchBox(), wait, product);
		click(searchButton(), wait, message);
		
	}

}
