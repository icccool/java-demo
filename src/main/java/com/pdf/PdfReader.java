package com.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/***
 * 解析pdf中单词
 *
 */
public class PdfReader {
    public static void main(String[] args) throws IOException {

        File myFile = new File("/Users/mac/Documents/pandp12p.pdf");
        File myFile2 = new File("/Users/mac/Documents/A.Song.of.Ice.and.Fire.-.All.3.Books.pdf");
        Set<String> wdSet = new HashSet<>();
        //按单词的长度排序
        Map<String, Integer> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    if (o1.equalsIgnoreCase(o2)) {
                        return 0;
                    } else {
                        return 1;
                    }
                }
            }
        });

        try (PDDocument pdDoc = PDDocument.load(myFile2)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(pdDoc);
            String[] strs = null;
            int pages = pdDoc.getNumberOfPages();
            stripper.setStartPage(1);
            stripper.setEndPage(11);
            String txt = stripper.getText(pdDoc);
            strs = txt.split("\\s+");
            for (int i = 0; i < strs.length; i++) {
                String wd = strs[i].toLowerCase();
                if (wd.length() > 4 && wd.length() < 16) {
                    //wd = wd.replaceAll("-", "");
                    String reg = "[^a-zA-Z]";
                    wd = wd.replaceAll(reg, "");
                    wdSet.add(wd);
                    //单词出现次数
                    Integer cnt = null;
                    if ((cnt = treeMap.get(wd)) == null) {
                        treeMap.put(wd, new Integer(1));
                    } else {
                        treeMap.put(wd, cnt + 1);
                    }
                }
            }
            System.out.println("=====================================================");
            HashSet<String> set = new HashSet<>();
            for (Map.Entry<String, Integer> v : treeMap.entrySet()) {
//                System.out.println(v.getKey() + "---->" + v.getValue());
                if (v.getValue() < 20) {
                    set.add(v.getKey());
                }
            }
            writeToFile(set);
        }
    }


    private static void writeToFile(HashSet<String> set) throws IOException {
        File file = new File("/Users/mac/Documents/wds.txt");
        //if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        List<String> tmp = new ArrayList<>(10);
        for (String w : set) {
            tmp.add(w);
            if (tmp.size() == 10) {
                StringBuilder buff = new StringBuilder();
                for (String s : tmp) {
                    buff.append(s + "%0");
                }
                fw.write(String.format("$.get(\"https://www.shanbay.com/bdc/vocabulary/add/batch/?words=%s&_=1544360645175\")", buff.substring(0, buff.length() - 2)) + "\r\n");
                tmp.clear();
            }
        }
        fw.close();
        System.out.println("Done");
    }
}