package com.code.io.poi.importfile;

import java.io.File;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		
		ExcelFile excel = new ExcelFile(new File("C:\\Users\\John\\Desktop\\coupon2.xlsx"), 1);
		long start = System.currentTimeMillis();
		int rowCount = excel.read();
		System.out.println(System.currentTimeMillis() - start);
		System.out.println("rowCount -> " + rowCount);
	}
}
