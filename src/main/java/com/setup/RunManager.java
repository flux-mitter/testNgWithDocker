package com.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.constants.Contstants;
import com.testdata.util.ExcelPojo;

import lombok.Getter;

public class RunManager

{
	private static ThreadLocal<Map<String, ExcelPojo>> excelRunner = new ThreadLocal<>();

	private static void setExcelValue() {
		Map<String, ExcelPojo> runner = new HashMap<String, ExcelPojo>();
		try {
			FileInputStream fs = new FileInputStream(Contstants.getRUNMANAGERPATH());
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet("RunManager");
			int rownum = sheet.getLastRowNum();
			int columnnum = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= rownum; i++) {
				String testCaseName = null;
				String testCaseDescription = null;
				String execute = null;
				int invocationCount = 0;
				int priority = 0;
				// ExcelPojo excelPojo;
				for (int j = 0; j < columnnum; j++) {
					// excelPojo = new
					// ExcelPojo(sheet.getRow(i).getCell(j),sheet.getRow(i).getCell(j),);
					switch (j) {
					case 0:
						testCaseName = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case 1:
						testCaseDescription = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case 2:
						execute = sheet.getRow(i).getCell(j).getStringCellValue();
						break;
					case 3:
						// invocationCount =
						// Integer.parseInt(sheet.getRow(i).getCell(j).getStringCellValue());
						invocationCount = Integer.parseInt(sheet.getRow(i).getCell(j).getRawValue());
						break;
					case 4:
						priority = Integer.parseInt(sheet.getRow(i).getCell(j).getRawValue());
						break;

					}

				}
				runner.put(testCaseName,
						new ExcelPojo(testCaseName, testCaseDescription, execute, invocationCount, priority));
			}
		//	System.out.println(runner);
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		//	System.out.println();
		}
		excelRunner.set(runner);

	}

	public static Map<String, ExcelPojo> getExcelValue() {
		setExcelValue();
		return excelRunner.get();

	}

}
