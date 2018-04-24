package com.code.time;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest {
	public static void main(String[] args) {
		long nano = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MILLISECONDS);
		System.out.println(nano);
	}
}
