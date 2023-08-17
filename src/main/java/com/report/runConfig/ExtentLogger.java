package com.report.runConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.setup.DriverManager;

public final class ExtentLogger {
	
	private ExtentLogger()
	{
		
	}
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message,boolean isScreenShotNeeded)
	{
		if(PropertiesUtils.get(ConfigEnum.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("Yes")&&isScreenShotNeeded)
		{
			ExtentManager.getExtentTest().pass(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else
		{
			pass(message);
		}
	}
	public static void fail(String message,boolean isScreenShotNeeded)
	{
		if(PropertiesUtils.get(ConfigEnum.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("Yes")&&isScreenShotNeeded)
		{
			ExtentManager.getExtentTest().fail(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else
		{
			fail(message);
		}
	}
	public static void skip(String message,boolean isScreenShotNeeded)
	{
		if(PropertiesUtils.get(ConfigEnum.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("Yes")&&isScreenShotNeeded)
		{
			ExtentManager.getExtentTest().skip(message, 
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else
		{
			skip(message);
		}
	}
	
	public static String getBase64Image()
	{
		
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
