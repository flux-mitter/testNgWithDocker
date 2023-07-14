package com.constants;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.UtilityClass;


public class Contstants {
	@Getter
	private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources/com/resources";
	@Getter
	private static final String CONFIGPROPPATH = PATHTORESOURCES + "/config.properties";
	@Getter
	private static final String CONFIGJSONPATH = PATHTORESOURCES + "/jsons/config.json";
	@Getter
	private static final String EXCELPATH = System.getProperty("user.dir") + "/excel/SampleTestDataWorkbook.xlsx";
	@Getter
	private static final String EXTENTREPORFOLDERTPATH = System.getProperty("user.dir") + "/ExtentReport-output/";
	@Getter
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	@Getter
	private static final String DATASHEET = "DATA";
	@Getter
	private static final int EXPLICITLYWAITTIME = 30;

}
