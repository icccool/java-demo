package com.crawler;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

public class CrawlerImgs {

    public static void main(String[] args) {
        String urlStr = "https://nafion1324.tumblr.com/";
        List<String> imageUrlStrList = new ArrayList<>();
        Document document = getDocByUrl(urlStr);
        imageUrlStrList.addAll(getImageUrlList(document));
        for (String imageUrlStr : imageUrlStrList) {
            System.out.println("imageUrlStr:" + imageUrlStr);
        }
    }

    /**
     * 获取图片链接列表
     * @param document 等地啊分析的文档
     * @return
     */
    public static List<String> getImageUrlList(Document document) {
        List<String> imageUrlStrList = new ArrayList<>();
        Elements elements = document.getElementsByTag("img");
        for (Element element : elements) {
            String imageUrlStr =  element.attr("src");
            if (imageUrlStr != null && imageUrlStr != "") {
                imageUrlStrList.add(imageUrlStr);
            }
        }
        return imageUrlStrList;
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
