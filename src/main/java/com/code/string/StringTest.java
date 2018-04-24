package com.code.string;

import java.nio.charset.Charset;

public class StringTest {
	public static void main(String[] args) {
		String csn = Charset.defaultCharset().name();
		System.out.println(csn);
		
		String abc = new String("abc");
		String ab = "ab";
		String abc1 = ab + "c";
		System.out.println(abc1.intern() == "abc");
		System.out.println(abc.intern());
		String a = "a" + "b";
		String s = a + "c" + "d";
		System.out.println(s == "abcd");
		
		String s1 = "a" + "b" + "c" + "d";
		System.out.println(s1 == "abcd");

	}
}
