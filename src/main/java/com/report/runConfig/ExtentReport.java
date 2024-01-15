package com.report.runConfig;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.Contstants;

public final class ExtentReport {

	private ExtentReport() {

	}

	public static ExtentReports extent;
//	public static ExtentTest test;

	public static void initReports() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(Contstants.getExtentreportfiletpath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Testing Extent Report");
			spark.config().setReportName("Advance TestNG");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
//		try {
//			Desktop.getDesktop().browse(new File(Contstants.getExtentreportfiletpath()).toURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void createTest(String testCaseName) {
		ExtentTest test = extent.createTest(testCaseName);
		ExtentManager.setExtentTest(test);
	}

}
