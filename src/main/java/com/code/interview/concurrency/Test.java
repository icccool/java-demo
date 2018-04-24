package com.code.interview.concurrency;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		//false
		System.out.println(3 * 0.1 == 0.3);
		
		//0
		int v = new BigDecimal("3").multiply(new BigDecimal("0.1")).compareTo(new BigDecimal("0.3"));
		System.out.println(v);
	}
}
