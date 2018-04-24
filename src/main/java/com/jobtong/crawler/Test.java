package com.jobtong.crawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jobtong.bean.People;

public class Test {
	public static void main(String[] args) {

		// CrawlerService service = new CrawlerService();
		// service.resolveHtmlPage("http://www.jobtong.com/p/372230");
		//
		BufferedReader reader = null;
		try {
			// http://www.jobtong.com/p/372120
			// http://www.jobtong.com/p/372230
			String fileName = "C:\\Users\\W\\Desktop\\372120.txt";
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			String line = null;
			StringBuilder sbf = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				sbf.append(line);
			}

			String regex = "<script id=\"preloaded\" type=\"text/plain\">(.+?)</script>";
			Pattern r = Pattern.compile(regex);
			Matcher m = r.matcher(sbf);
			String content = null;
			if (m.find()) {
				content = m.group(1);
			}
			System.out.println(content);
			JSONObject obj = JSON.parseObject(content);
			JSONObject peopleObj = obj.getJSONObject("people");
			People people = new People(peopleObj);
			System.out.println(people);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
				}
			}
		}

	}
}
