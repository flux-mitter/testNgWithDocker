package com.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.setup.RunManager;
import com.testdata.util.DataProviderExcel;
import com.testdata.util.ExcelPojo;
public class TestingData {
	
	@Test(dataProvider = "excelIterations", dataProviderClass = DataProviderExcel.class,enabled=false)
	public void testingExcelData(Map<String,String> map)
	{
		System.out.println(map.get("username"));
	}
	
	
	@Test
	public void excelTest()
	{
		//System.out.println(RunManager.getExcelValue().get());
		RunManager.getExcelValue().forEach((k,v) -> System.out.println(k+" : "+v.getTestCaseDescription()));
		
	}

}
