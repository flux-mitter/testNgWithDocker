package com.constants;

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
	@Getter
	private static final String EXTENTREPORFOLDERTPATH = System.getProperty("user.dir") + "/ExtentReport-output/";
	@Getter
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	@Getter
	private static final String DATASHEET = "DATA";
	@Getter
	private static final int EXPLICITLYWAITTIME = 30;

}
