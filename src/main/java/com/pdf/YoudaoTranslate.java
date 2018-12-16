package com.pdf;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class YoudaoTranslate {

    public static void main(String[] args) {
        translate("neighbourhood");
    }

    public static void translate(String word) {
        HttpGet get = new HttpGet("http://fanyi.youdao.com/openapi.do?keyfrom=youdao111&key=60638690&type=data&doctype=xml&version=1.1&q="
                        + word);
        try {
            HttpClient client = HttpClients.createDefault();
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity, "UTF-8");

            org.dom4j.Document doc = (org.dom4j.Document) DocumentHelper
                    .parseText(str);
            Element root = (Element) doc.getRootElement();
            Element query = root.element("query");
            List clist = root.elements();
            System.out.println("原文:" + query.getText());
            Element paragraph = (Element) root.element("translation")
                    .element("paragraph");
            System.out.println("翻译:" + paragraph.getText());
            if (clist.size() > 3) {
                List<Element> exlists = root.element("basic").element("explains").elements();
                for (Element e : exlists) {
                    System.out.println("   " + e.getText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
