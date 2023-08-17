package com.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class UtilityMethods {
	
	public static List<String> monthDay(int dayDifference) {
		List<String> dayMonth = new ArrayList<String>();
		LocalDate currentdate = LocalDate.now().plusDays(dayDifference);
		Month currentMonth = currentdate.getMonth();
		int currentYear = currentdate.getYear();

		int day = currentdate.getDayOfMonth();
		//System.out.println(currentMonth);
		//System.out.println(day);
		String month=String.valueOf(currentMonth);
		dayMonth.add(month.charAt(0)+month.substring(1, month.length()).toLowerCase());
		dayMonth.add(String.valueOf(day));
		return dayMonth;

	}

}
