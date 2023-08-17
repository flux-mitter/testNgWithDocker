package com.tests;

import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.pages.AirAvailability;
import com.pages.HomePage;
import com.setup.DriverManager;

@Listeners({com.report.runConfig.AllureTestListener.class})
public class BaseTest {
	
	HomePage homePage;
	AirAvailability airAvailability;
	
	@BeforeMethod
	public void setUp()
	{
		DriverManager.setDriver(PropertiesUtils.get(ConfigEnum.BROWSER), PropertiesUtils.get(ConfigEnum.BROWSERVERSION));
		if(Objects.isNull(homePage))
		{
		homePage=new HomePage();
		airAvailability = new AirAvailability();
		}
		
	}
	@AfterMethod
	protected void tearDown() {
		DriverManager.quitDriver();
		homePage=null;
		airAvailability=null;
	}
	
//	@AfterSuite
//	public void displayOutput() throws IOException
//	{
//		Runtime runtime = Runtime.getRuntime();
//		String cmd = "allure serve "+"\""+System.getProperty("user.dir")+"/allure-results"+"\"";
//		System.out.println(cmd);
//		Process process = runtime.exec(cmd);
//	}
}
