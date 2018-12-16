package com.crawler.tumblr;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class Crawler {

    public static void main(String[] args) {
        String urlStr = "http://www.tumblr.com";
        Document document = getDocByUrl(urlStr);
        System.out.println(document.toString());
    }

    /**
     * 获取链接，并且处理异常
     *
     * @param url 待获取的链接
     * @return
     */
    public static Document getDocByUrl(String url) {
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1087));
        Connection connection = Jsoup.connect(url).proxy(proxy);
        try {
            return connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
