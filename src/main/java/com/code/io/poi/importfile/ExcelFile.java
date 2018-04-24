package com.code.io.poi.importfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	private static final int NTHREADS = 10;
	private static final ExecutorService exc = Executors.newFixedThreadPool(NTHREADS);

	int sheetIndex = 0;
	int headRow = 0;
	private Workbook wb;
	private Sheet sheet;
	String fileName;

	private ExcelFile(String fileName, InputStream in, int headRow) throws IOException {
		this.fileName = fileName;
		this.headRow = headRow;

		if (fileName.toLowerCase().endsWith("xls")) {
			this.wb = new HSSFWorkbook(in);
		} else if (fileName.toLowerCase().endsWith("xlsx")) {
			this.wb = new XSSFWorkbook(in);
		} else {
			throw new RuntimeException("文档格式不正确!");
		}
		if (this.wb.getNumberOfSheets() < sheetIndex) {
			throw new RuntimeException("文档中没有工作表!");
		}
		this.sheet = this.wb.getSheetAt(sheetIndex);
	}

	public ExcelFile(File file, int headRow) throws IOException {
		this(file.getName(), new FileInputStream(file), headRow);
	}

	public String getStringValue(int row, int cell) {
		return this.sheet.getRow(row).getCell(cell).getStringCellValue();
	}

	public int getLastRowNum() {
		return this.sheet.getLastRowNum() + 1;
	}

	public int read() {
		int rowCount = 0;
		final int total = this.getLastRowNum() - headRow;
		if (total > 200000) {
			// 多线程处理
			System.out.println("单线程");
			for (int i = 0; i < total; i++) {
				String code = getStringValue(i, 0);
				rowCount++;
			}
		} else {
			// 多线程处理
			System.out.println("多线程");
			List<Future<Integer>> list = new ArrayList<Future<Integer>>();
			for (int i = 0; i < NTHREADS; i++) {
				final int lo = total / NTHREADS * i + headRow;
				final int hi = total / NTHREADS * (i + 1) + headRow;
				list.add(exc.submit(new ExcelCallable(this, lo, i == NTHREADS - 1 ? this.getLastRowNum() : hi)));
			}
			// 取得返回执行结果
			for (int i = 0; i < list.size(); i++) {
				Future<Integer> future = list.get(i);
				try {
					rowCount += future.get();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
		return rowCount;
	}

}
