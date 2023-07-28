package com.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.pages.HomePage;
import com.setup.DriverManager;

@Listeners({com.report.runConfig.AllureTestListener.class})
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
	
//	@AfterSuite
//	public void displayOutput() throws IOException
//	{
//		Runtime runtime = Runtime.getRuntime();
//		String cmd = "allure serve "+"\""+System.getProperty("user.dir")+"/allure-results"+"\"";
//		System.out.println(cmd);
//		Process process = runtime.exec(cmd);
//	}
}
