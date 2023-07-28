package com.report.runConfig;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.setup.DriverManager;

import io.qameta.allure.Attachment;

public class Retry implements IRetryAnalyzer {
//	private int count = 0;

	private static int maxTry = Integer.parseInt(PropertiesUtils.get(ConfigEnum.MAXRETRY));
	private int count = 0;
//	private static int maxTry = 1;
	private static String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();
	}
	@Override
	 public boolean retry(ITestResult iTestResult) {
		System.out.println(PropertiesUtils.get(ConfigEnum.MAXRETRY));
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                WebDriver driver = DriverManager.getDriver();
        		// Allure ScreenShot and SaveTestLog
        		if (driver instanceof WebDriver) {
        			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
        			//captureScreenshot(driver);
        			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        			 attachScreenshot(screenshot);
        		}
        		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
                return true;                                 //Tells TestNG to re-run the test
            } else {
            	
                iTestResult.setStatus(ITestResult.FAILURE);  //If maxCount reached,test marked as failed
            }
        } else {
        	WebDriver driver = DriverManager.getDriver();
    		// Allure ScreenShot and SaveTestLog
    		if (driver instanceof WebDriver) {
    			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
    			//captureScreenshot(driver);
    			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    			 attachScreenshot(screenshot);
    		}
    		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }
	@Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }
	@Attachment(value="{0}", type = "text/plain")
	public static String saveTextLog(String message)
	{
		return message;
	}
	
   
}
