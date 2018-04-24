package com.code.string;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex
{
	public static void main(String[] args) {
		String str = "{4}";

		Pattern p = Pattern.compile("\\{\\d+\\}");
		Matcher m = p.matcher(str);
		while (m.find()){
			System.out.println(m.group());
		}
		System.out.println("-------------------------");
	}
}
