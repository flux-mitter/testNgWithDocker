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
import org.testng.annotations.Parameters;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.pages.AirAvailability;
import com.pages.AmazonHomePage;
import com.pages.HomePage;
import com.pages.ProductSearchResult;
import com.report.runConfig.ExtentLogger;
import com.setup.DriverManager;

@Listeners({com.report.runConfig.AllureTestListener.class})
public class BaseTest {
	
	HomePage homePage;
	AirAvailability airAvailability;
	AmazonHomePage amazonHomePage;
	ProductSearchResult productSearchResult;

	public BaseTest() {
		super();
	}

	@BeforeMethod
	@Parameters({"BROWSER","BROWSERVERSION"})
	public void setUp(String browser, String browserVersion)
	{
		//DriverManager.setDriver(PropertiesUtils.get(ConfigEnum.BROWSER), PropertiesUtils.get(ConfigEnum.BROWSERVERSION));
		//DriverManager.setDriver(browser,browserVersion);
		if(Objects.isNull(System.getProperty("browserName")))
		{
			DriverManager.setDriver(browser,browserVersion);
		}
		else
		{
			DriverManager.setDriver(System.getProperty("browserName"), browserVersion);
		}
		if(Objects.isNull(homePage))
		{
		homePage=new HomePage();
		airAvailability = new AirAvailability();
		amazonHomePage=new AmazonHomePage(); 
		productSearchResult = new ProductSearchResult();
		
		}
		
	}
//	@Parameters({"BROWSER","BROWSERVERSION"})
//	@BeforeTest
//	public void browserLaunched(String browser, String browserVersion)
//	{
//		ExtentLogger.pass("Application launched with : "+browser+" and url :"+ConfigEnum.URL ,true);
//	}
	
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
