package com.testdata.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.constants.Contstants;

public class DataProviderExcel 
{
	@DataProvider(name = "excelIterations")
	public Object[] excelData() {
		Object[] data=null;
		try {
			FileInputStream fs = new FileInputStream(Contstants.getEXCELPATH());
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("TestData");
			int rownum = sheet.getLastRowNum();
			int columnnum = sheet.getRow(0).getLastCellNum();

			data = new Object[rownum];
			Map<String, String> map;
			for (int i = 1; i <= rownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < columnnum; j++) {
					map.put(sheet.getRow(0).getCell(j).getStringCellValue(), sheet.getRow(i).getCell(j).getStringCellValue());
					data[i-1]=map;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();

		}
		return data;
		
	
	}
}
