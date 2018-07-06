package com.code.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) {
		compare();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2006);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 3);
		cal.add(Calendar.DATE, -4);
		Date date = cal.getTime();
		System.out.println(df.format(date));



	}

	//去掉时分秒对比时间
	public static void compare() {
		try {
			Date now = sdf.parse(sdf.format(new Date()));
			Date startDate = sdf.parse(sdf.format(new Date()));
			Date endDate = sdf.parse(sdf.format(new Date()));
			if (startDate.getTime() <= now.getTime() && now.getTime() <= endDate.getTime()) {
				System.out.print("范围类");
			} else {
				System.out.print("xxxxxxxxxxxxxxxx");
			}
		} catch (Exception e) {

		}
	}
}
