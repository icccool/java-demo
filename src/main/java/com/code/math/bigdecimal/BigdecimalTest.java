package com.code.math.bigdecimal;

import java.math.BigDecimal;

public class BigdecimalTest {
	public static void main(String[] args) {
		try {
			BigDecimal n1 = new BigDecimal("1");
			BigDecimal n2 = new BigDecimal("3");
			double d = n1.divide(n2, 2, BigDecimal.ROUND_DOWN).doubleValue();

			BigDecimal num = new BigDecimal("-0.00000000001");
			if(num != null && num.compareTo(BigDecimal.ZERO) > 0){
				System.out.println("num 大于0.");
			}

			//System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
