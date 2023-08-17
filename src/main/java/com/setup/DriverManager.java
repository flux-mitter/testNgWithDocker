package com.setup;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private DriverManager(){
		
	}
	
	
	private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
	
	public static void setDriver(String browser,String version)
	{
		System.out.println("Before new Window :"+localDriver.get());
		if(Objects.isNull(localDriver.get()))
		{
			Driver driver= new Driver();
		localDriver.set(driver.getDriver(browser,version));
		}
	}
	
	public static WebDriver getDriver() {
		return localDriver.get();
	}
	
	
	public static void quitDriver() {
		//localDriver.remove();
		if((Objects.nonNull(localDriver.get())))
//		{
			getDriver().quit();
			localDriver.remove();
			//Driver.setDriverNull();
		}
	}
	
	

