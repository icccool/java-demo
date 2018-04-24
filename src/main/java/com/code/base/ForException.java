package com.code.base;

/**
 * for 循环加try catch , 中间出错可以后续可以继续执行
 * @author W
 *
 */
public class ForException {

	public static void pnt(int i) {
		if (i == 10) {
			throw new NullPointerException("i = " + i);
		}
		System.out.println("i --> " + i);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			try {
				pnt(i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
