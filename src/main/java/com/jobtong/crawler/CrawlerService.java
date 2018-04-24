package com.jobtong.crawler;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jobtong.bean.People;
import com.jobtong.utils.HttpClientUtils;

/**
 * 抓取jobtong的简历信息
 *
 */
public class CrawlerService implements Runnable {

	private int start;
	private int end;

	private static final String BASE_PATH = "F:" + File.separator + "Download" + File.separator + "resumes";

	public CrawlerService() {
	}

	public CrawlerService(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public People resolveHtmlPage(String url) {
		String htmlContent = HttpClientUtils.get(url);
		if (StringUtils.isEmpty(htmlContent)) {
			return null;
		}
		String regex = "<script id=\"preloaded\" type=\"text/plain\">(.+?)</script>";
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher(htmlContent);
		String content = null;
		if (m.find()) {
			content = m.group(1);
		}
		if (StringUtils.isEmpty(content)) {
			return null;
		}
		JSONObject obj = JSON.parseObject(content);
		// 用户信息
		JSONObject peopleObj = obj.getJSONObject("people");
		People people = new People(peopleObj);
		if ("HR".equals(people.getCompany_position())) {
			return null;
		}
		// 存入指定文件件内
		String cityName = people.getCurrent_city_name();
		String basePath = BASE_PATH + File.separator + "other" + File.separator;
		if (!StringUtils.isEmpty(cityName)) {
			basePath = BASE_PATH + File.separator + cityName + File.separator;
		}
		File file = new File(basePath);
		if (!file.exists()) {
			file.mkdir();
		}

		// 用户简历
		JSONObject resume = obj.getJSONObject("people-resume");
		// doc 简历
		JSONArray attachment = resume.getJSONArray("attachment");
		for (int i = 0; attachment != null && i < attachment.size(); i++) {
			JSONObject attach = attachment.getJSONObject(i);
			String doc_url = String.valueOf(attach.get("url"));
			HttpClientUtils.download(doc_url, basePath + people.getName() + people.getId() + i + ".doc");
		}
		// 头像
		String photo_url = people.getPhoto_url();
		if (!StringUtils.isEmpty(photo_url)) {
			String suffix = photo_url.substring(photo_url.lastIndexOf("."), photo_url.length());
			if (!".png".equals(suffix)) {
				HttpClientUtils.download(people.getPhoto_url(), basePath + people.getName() + people.getId() + suffix);
			}
		}
		// pdf 简历
		String download_url = String.valueOf(resume.get("download_url"));
		if (!StringUtils.isEmpty(download_url) && download_url.indexOf("pdf") > -1) {
			HttpClientUtils.download(download_url, basePath + people.getName() + people.getId() + ".pdf");
		}
		return people;
	}

	public static void main(String[] args) {
		int start = 100000;
		int end = 490000;
		int pageSize = 4000;
		for (int i = 0; i * pageSize < end; i++) {
			int lo = start + i * pageSize;
			int hi = start + (i + 1) * pageSize;
			System.out.println(lo + "--> " + hi);
			new Thread(new CrawlerService(lo, hi)).start();
		}

		// CrawlerService service = new CrawlerService();
		// 304645
		// service.resolveHtmlPage("http://www.jobtong.com/p/304645");

	}

	public void run() {
		for (int i = start; i < end; i++) {
			resolveHtmlPage("http://www.jobtong.com/p/" + i);
		}
	}

}
