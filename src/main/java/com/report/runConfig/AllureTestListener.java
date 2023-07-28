package com.report.runConfig;

import java.io.IOException;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.config.PropertiesUtils;
import com.enums.ConfigEnum;
import com.setup.DriverManager;
import io.qameta.allure.Attachment;

public class AllureTestListener extends TestListenerAdapter{
	
	
//	private int count = 0;
//	private static int maxTry = 3;

	private static String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();
	}
//	@Override
//    public void onTestFailure(ITestResult result) {
//        takeScreenshot(result.getName());
////        saveTextLog(result.getMethod().getConstructorOrMethod().getName() + " failed and screenshot taken!");
//    }

//	@Attachment(value = "Page Screenshot", type = "image/png")
//    public byte[] takeScreenshot(String methodName) {
//        // Add code to take a screenshot and return the byte array of the screenshot
//		TakesScreenshot screenshotDriver = (TakesScreenshot) DriverManager.getDriver();
//		byte[] screenshotBytes = screenshotDriver.getScreenshotAs(OutputType.BYTES);
//
//        return screenshotBytes;
//		
//    }
//	@Attachment(value="{0}", type = "image/png")
//	public byte[] saveFailureScreenShot(WebDriver driver) {
//		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//	}
//	@Attachment(value = "Test Execution Log", type = "text/plain")
//    public String saveTextLog(String message) {
//        // Add code to save the log message and return the log message
//    }
	
//	@Attachment(value="{0}", type = "text/plain")
//	public static String saveTextLog(String message)
//	{
//		return message;
//	}
	
	
	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", DriverManager.getDriver());
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("I am in onFinish method " + iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
	}

//	public void onTestFailure(ITestResult iTestResult) {
//		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
////		Object testClass = iTestResult.getInstance();
//		WebDriver driver = DriverManager.getDriver();
//		// Allure ScreenShot and SaveTestLog
//		if (driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//			saveFailureScreenShot(driver);
//		}
//		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");	
//	}
	
//	@Override
//	public void onTestFailure(ITestResult iTestResult) {
//		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
//		Object testClass = iTestResult.getInstance();
//		WebDriver driver = DriverManager.getDriver();
//		// Allure ScreenShot and SaveTestLog
//		if (driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//			saveFailureScreenShot(driver);
//		}
//		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");	
//	}
//	@Override
//	public void onTestFailure(ITestResult iTestResult) {
//		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
//		Object testClass = iTestResult.getInstance();
//		WebDriver driver = DriverManager.getDriver();
//		// Allure ScreenShotRobot and SaveTestLog
//		if (driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//			saveScreenshotPNG(driver);
//		}
//		// Save a log on allure.
//		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");		
//	}
//	@Attachment(value = "Page screenshot", type = "png")
//    public byte[] captureScreenshot(WebDriver d) {
//        return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
//    }
//    @Override
//    public void onTestFailure(ITestResult tr) {
//        Object webDriverAttribute = DriverManager.getDriver();
//        if (webDriverAttribute instanceof WebDriver) {
//            System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
//            captureScreenshot((WebDriver) webDriverAttribute);
//        }
//    }

	
	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
	
//	// Text attachments for Allure
//		@Attachment(value = "Page screenshot", type = "image/png")
//		public byte[] saveScreenshotPNG(WebDriver driver) {
//			return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//		}
//	
//	public void run(IHookCallBack callBack, ITestResult testResult) {
//
//        callBack.runTestMethod(testResult);
//        if (testResult.getThrowable() != null) {
//            try {
//                takeScreenShot(testResult.getMethod().getMethodName());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Attachment(value = "Failure in method {0}", type = "image/png")
//    private byte[] takeScreenShot(String methodName) throws IOException {
//        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//    }
	
	
	
//	@Attachment(value="{0}", type = "text/plain")
//	public static String saveTextLog(String message)
//	{
//		return message;
//	}
//	
//	@Attachment(value = "Page screenshot", type = "image/png")
//  public byte[] captureScreenshot(WebDriver d) {
//      return ((TakesScreenshot) d).getScreenshotAs(OutputType.BYTES);
//  }
//	
//	@Override
//	public void onTestFailure(ITestResult iTestResult) {
//		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
////		Object testClass = iTestResult.getInstance();
//		WebDriver driver = DriverManager.getDriver();
//		// Allure ScreenShot and SaveTestLog
//		if (driver instanceof WebDriver) {
//			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
//			captureScreenshot(driver);
//		}
//		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");	
//	}
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
//		Object testClass = iTestResult.getInstance();
		WebDriver driver = DriverManager.getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			//captureScreenshot(driver);
			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			 attachScreenshot(screenshot);
		}
		saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
//		if (count < maxTry) {
//	        count++;
//	        TestNG tng = new TestNG();
//	        tng.setDefaultTestName("RETRY TEST");
//	        Class[] classes1 = { iTestResult.getTestClass().getRealClass() };
//	        tng.setTestClasses(classes1);
//	        tng.addListener(new TestListenerAdapter());
//	        tng.run();
//	    }
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
