package com.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.testdata.util.DataProviderExcel;
public class TestingData {
	
	@Test(dataProvider = "excelIterations", dataProviderClass = DataProviderExcel.class)
	public void testingExcelData(Map<String,String> map)
	{
		System.out.println(map.get("username"));
	}

}
