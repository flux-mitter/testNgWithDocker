package com.setup;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	
	private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
	
	public static void setDriver(String browser,String version)
	{
		
		localDriver.set(Driver.getDriver(browser,version));
	}
	
	public static WebDriver getDriver() {
		return localDriver.get();
	}
	
	
	public static void quitDriver() {
		//localDriver.remove();
//		if((Objects.isNull(localDriver.get())))
//		{
			getDriver().quit();
			localDriver.remove();
			Driver.setDriverNull();
//		}
	}
	
	

}
