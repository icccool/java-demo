package com.code.number;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalAdd {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<String>();
		ls.add("67.52");
		ls.add("204.30");
		ls.add("63.33");
		ls.add("108.18");
		ls.add("117.10");
//		ls.add("0.00");
		ls.add("13.70");
		ls.add("160.90");
		ls.add("24.60");
		ls.add("7.60");
		ls.add("20.00");
		ls.add("63.60");
		ls.add("3.40");
		ls.add("87.80");
		ls.add("34.20");
		ls.add("11.98");
		ls.add("165.28");
		ls.add("98.53");
		ls.add("99.46");
		ls.add("37.30");
		ls.add("66.34");
		ls.add("20.90");
		ls.add("117.61");
		ls.add("150.50");
		ls.add("181.58");
		ls.add("39.97");
		ls.add("27.96");
		ls.add("101.13");
		ls.add("119.82");
		ls.add("96.80");
		ls.add("19.30");
		ls.add("11.00");
		ls.add("172.35");
		ls.add("19.50");
		ls.add("41.80");
		ls.add("53.10");
		ls.add("24.30");
		ls.add("159.26");
		ls.add("26.37");
		ls.add("19.00");
		ls.add("6.98");
		ls.add("13.48");
		ls.add("45.50");
		ls.add("19.50");
		ls.add("178.20");
		ls.add("16.60");
		ls.add("39.41");
		ls.add("9.90");
		ls.add("9.90");
		ls.add("76.80");
		ls.add("28.50");
		ls.add("136.90");
		ls.add("144.40");
		ls.add("159.60");
		ls.add("285.60");
		ls.add("50.00");
		ls.add("107.10");
		ls.add("110.62");
		ls.add("586.13");
		ls.add("36.20");
		ls.add("141.88");
		ls.add("89.56");
		ls.add("100.00");
		ls.add("16.10");
		ls.add("103.23");
		ls.add("194.50");
		ls.add("58.50");
		//ls.add("0.00");
		ls.add("460.78");
		ls.add("19.50");
		ls.add("103.95");
		//ls.add("0.00");
		//ls.add("0.00");
		ls.add("41.42");
		ls.add("63.75");
		ls.add("2.70");
		ls.add("102.04");
		ls.add("131.43");
		ls.add("8.00");
		ls.add("12.16");
		ls.add("56.65");
		ls.add("51.70");
		ls.add("30000.00");
		ls.add("49.01");
		ls.add("135.24");
		ls.add("38.19");
		ls.add("19.67");
		ls.add("91.11");
		ls.add("40.60");
		ls.add("42.04");
		ls.add("12.50");
		ls.add("116.12");
		ls.add("69.64");
		ls.add("46.21");
		ls.add("113.05");
		ls.add("412.15");
		ls.add("66.93");
		ls.add("101.86");
		ls.add("289.05");
		ls.add("3.70");
		ls.add("41.84");
		ls.add("19.50");
		ls.add("39.10");
		//ls.add("0.00");
		ls.add("99.72");
		ls.add("527.10");
		ls.add("43.02");
		ls.add("27.89");
		ls.add("21.45");
		ls.add("11.03");
		ls.add("11.48");
		ls.add("11.42");
		ls.add("98.37");
		ls.add("33.11");
		ls.add("188.96");
		ls.add("66.42");
		ls.add("46.73");
		ls.add("98.28");
		ls.add("32.23");
		ls.add("47.82");
		ls.add("22.34");
		ls.add("219.50");
		ls.add("58.60");
		ls.add("69.26");
		ls.add("95.00");
		ls.add("63.40");
		ls.add("46.35");
		ls.add("126.15");
		ls.add("98.37");
		ls.add("97.21");
		//错误
		float sum = 0.0f;
		for (int i = 0; i < ls.size(); i++) {
			sum += Float.valueOf(ls.get(i));
		}
		System.out.println(sum); //40685.277

		//正确
		BigDecimal bsum = new BigDecimal("0");
		for (int i = 0; i < ls.size(); i++) {
			bsum = bsum.add(new BigDecimal(ls.get(i)));
		}
		System.out.println(bsum.floatValue()); //40685.26

	}
}
