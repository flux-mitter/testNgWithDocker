package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.pages.HomePage;
import com.setup.DriverManager;


public class BaseTest {
	
	HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		DriverManager.setDriver(PropertiesUtils.get(ConfigEnum.BROWSER), PropertiesUtils.get(ConfigEnum.BROWSERVERSION));
		homePage=new HomePage();
		
	}
	@AfterMethod
	protected void tearDown() {
		DriverManager.quitDriver();
	}
}
