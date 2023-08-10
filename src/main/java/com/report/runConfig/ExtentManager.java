package com.report.runConfig;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.setup.Driver;

public class ExtentManager {
	
	private ExtentManager()
	{
		
	}

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	 static void setExtentTest(ExtentTest test) {

		extentTest.set(test);
	}

	 static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	 static void unload() {
		extentTest.remove();
	}
}
