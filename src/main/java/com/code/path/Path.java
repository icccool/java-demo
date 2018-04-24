package com.code.path;

import java.io.InputStream;

public class Path {

	public static void main(String[] args) {
		try {
			//============================================================
			String path = Path.class.getResource("test.properties").toString();
			InputStream in = Path.class.getResourceAsStream("test.properties");
			//file:/Users/john/Documents/workspace/java/target/classes/com/code/path/test.properties
			System.out.println(path + "==>" + in);
			//============================================================
			//file:/Users/john/Documents/workspace/java/target/classes/
			String path2 = Path.class.getResource("/").toString();
			System.out.println(path2);
			//============================================================
			//file:/Users/john/Documents/workspace/java/target/classes/
			String path3 = Path.class.getResource("").toString();
			System.out.println(path3);
			//============================================================
			///Users/john/Documents/workspace/java/target/classes/
			String path4 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			System.out.println(path4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
