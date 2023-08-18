package com.testdata.util;

import lombok.Getter;

public class ExcelPojo

{
	public ExcelPojo(String testCaseName, String testCaseDescription, String execute, int invocationCount,
			int priority) {
		this.testCaseName = testCaseName;
		this.testCaseDescription = testCaseDescription;
		this.execute = execute;
		this.invocationCount = invocationCount;
		this.priority = priority;
	}

	@Getter
	private String testCaseName;
	@Getter
	private String testCaseDescription;
	@Getter
	private String execute;
	@Getter
	private int invocationCount;
	@Getter
	private int priority;
	

}
