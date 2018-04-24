package com.code.io.poi.importfile;

import java.util.concurrent.Callable;

public class ExcelCallable implements Callable<Integer> {

	private int lo;
	private int hi;
	private ExcelFile excelFile;

	public ExcelCallable() {
	}

	public ExcelCallable(ExcelFile excelFile, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.excelFile = excelFile;
	}

	public Integer call() throws Exception {
		int rowCount = 0;
		for (int i = lo; i < hi; i++) {
			String code = excelFile.getStringValue(i, 0);
			rowCount++;
		}
		return rowCount;
	}

}
