package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    public static void main( String args[] ){
        tableName();
    }

    //统计？个数 ； 并替换第n个?为null
    static void tableName() {

        replace("ddd");
        String str="SELECT * FROM admin,USER WHERE AD = ?";
        int jo = str.toUpperCase().indexOf("JOIN");
        int fr = str.toUpperCase().indexOf("FROM");
        int wh = str.toUpperCase().indexOf("WHERE");
        if(jo > 0){

        }else {
            if (wh > -1) {
                System.out.println(str.substring(fr + 4, wh));
            } else {
                System.out.println(str.substring(fr + 4, str.length()));
            }
        }
    }

    static void replace(String stmt,Object ...objects) {

    }



        //统计？个数 ； 并替换第n个?为null
    static void replace(int n) {
        String sql = "UPDATE T SET T.A =?,T.A = ?,T.A =    ?  T.C IN ( ? ) and TC IN (?,'?DD?DD',?) and c = ?";
        String pattern = "=(\\s+)?\\?|\\((\\s+)?\\?|,(\\s+)?\\?(\\s+)?,|\\?(\\s+)?\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(sql);
        int cnt = 0;
        String oldMatch = null;
        while (m.find()) {
            cnt++;
            if (n > 0 && cnt == n) {
                sql.replace(m.group(), m.group().replace("?", "null"));
            }
        }
        System.out.println("sql :" + sql);
        System.out.println("cnt :" + cnt);
    }

    static void match1(){
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }

}
