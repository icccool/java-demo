package com.jobtong.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtils {

	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);

	static RequestConfig config = RequestConfig.custom().setConnectTimeout(6000).setSocketTimeout(6000).setCookieSpec(CookieSpecs.STANDARD).build(); // 设置超时及cookie策略

	public static String get(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(url);
			// httpGet.addHeader("User-Agent", USER_AGENT);
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			System.out.println("GET Response Status:: " + httpResponse.getStatusLine().getStatusCode());
			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			// print result
			return response.toString();
		} catch (Exception e) {
			try {
				httpClient.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param url
	 *            http://www.xxx.com/img/333.jpg
	 * @param destFileName
	 *            xxx.jpg/xxx.png/xxx.txt
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void download(String url, String destFileName) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet(url);
			HttpResponse response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();

			if (entity.getContentLength() <= -1) {
				logger.info("failed saved to {}", destFileName);
				return;
			}

			FileOutputStream fos = null;
			File file = new File(destFileName);
			try {
				fos = new FileOutputStream(file);
				byte[] buffer = new byte[4096];
				int len = -1;
				while ((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
				fos.flush();
				fos.close();
				is.close();
			} finally {
				if (fos != null)
					fos.close();
				if (is != null)
					is.close();
			}
			logger.info("successfully saved to {}", destFileName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		HttpClientUtils.download("http://www.jobtong.com/Tool/prepareResume?uid=372232", "C:\\Users\\W\\Desktop\\2222.pdf");

	}
}
