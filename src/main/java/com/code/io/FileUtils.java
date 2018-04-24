package com.code.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {

	public static void main(String[] args) {
		
	}

	//单个文件复制  copyFile("E:\\Printer.txt", "F:\\Printer.txt");
	public static void copyFile(String newPath, String oldPath) {
		try {
			FileInputStream in = new FileInputStream(newPath);
			FileOutputStream out = new FileOutputStream(oldPath);
			byte[] buff = new byte[1024];
			int len = -1;
			int sum = 0;
			if ((len = in.read(buff)) > -1) {
				sum += len;
				out.write(buff, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			String s = new String();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
