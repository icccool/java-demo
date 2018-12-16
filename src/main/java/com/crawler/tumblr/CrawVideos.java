package com.crawler.tumblr;

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
import java.util.regex.Pattern;

public class CrawVideos {

    public static void main(String[] args) {
        String urlStr = "http://blowjpq.tumblr.com";
        Document doc = getDocByUrl(urlStr);
        List<String> crawlVideoUrlList = crawlVideoUrl(doc);
    }

    public static List<String> crawlVideoUrl(Document doc) {

        List<String> videoCrawlUrlList = crawlNeedCrawlVideoUrl(doc);
        List<String> videoUrlList = new ArrayList<>();
        //真正的视频下载链接
        for (String videoCrawlUrl : videoCrawlUrlList) {
            Document videoDoc = getDocByUrl(videoCrawlUrl);
            if (videoDoc != null) {
                Elements videoElements = videoDoc.getElementsByTag("video");
                for (Element videoElement : videoElements) {

                    String videoUrl = videoElement.attr("src");
                    videoUrlList.add(videoUrl);
                    System.out.println("爬取的视频链接地址： " + videoUrl);
                }
            }
        }
        return videoUrlList;
    }

    /**
     * 抓去需要爬去的视频链接的链接
     *
     * @param doc
     * @return
     */
    public static List<String> crawlNeedCrawlVideoUrl(Document doc) {

        List<String> videoCrawlUrlList = new ArrayList<>();
        //爬图片和视频的链接
        Elements videoCrawlElements = doc.getElementsByTag("video");
        //视频预处理
        for (Element element : videoCrawlElements) {
            String videoCrawlUrl = element.attr("src");
            //通过正则过滤，判断是否为视频链接
            String pattern = "^.*video.*$";
            boolean isMatch = Pattern.matches(pattern, videoCrawlUrl);
            if (isMatch) {
                videoCrawlUrlList.add(videoCrawlUrl);
            }
        }
        return videoCrawlUrlList;
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
