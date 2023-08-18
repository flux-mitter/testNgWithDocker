package com.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;

import com.enums.ConfigEnum;

import lombok.Getter;

public class Contstants {

	private Contstants() {
		throw new IllegalStateException("Utility class");
	}
	

	@Getter
	private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources/com/resources";
	@Getter
	private static final String CONFIGPROPPATH = PATHTORESOURCES + "/config.properties";
	@Getter
	private static final String RUNMANAGERPATH = System.getProperty("user.dir") + "/runManager.xlsx";
	@Getter
	private static final String CONFIGJSONPATH = PATHTORESOURCES + "/jsons/config.json";
	@Getter
	private static final String EXCELPATH = PATHTORESOURCES + "/TestData.xlsx";
	private static final String EXTENTREPORTFOLDERTPATH = System.getProperty("user.dir") + "/ExtentReport-output/";
//	private static String EXTENTREPORTFILETPATH = System.getProperty("user.dir") + "/ExtentReport-output/";
	private static String EXTENTREPORTFILETPATH = "";

	@Getter
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	@Getter
	private static final String DATASHEET = "DATA";
	@Getter
	private static final int EXPLICITLYWAITTIME = 30;
	

	public static String getExtentreportfiletpath() {
		if(EXTENTREPORTFILETPATH.isEmpty())
		{
			EXTENTREPORTFILETPATH = createReportPath();
		}
		return EXTENTREPORTFILETPATH;
	}
	private static String createReportPath() {
		if (com.config.PropertiesUtils.get(ConfigEnum.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
//			return EXTENTREPORTFOLDERTPATH + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "/"
//					+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "_ExtentReport.html";
			return EXTENTREPORTFOLDERTPATH + "/index.html";
		} else {
//			return EXTENTREPORTFOLDERTPATH + "/" + "ExtentReport.html";
			return EXTENTREPORTFOLDERTPATH+System.currentTimeMillis()+"/index.html";
			 
		}
	}

}
