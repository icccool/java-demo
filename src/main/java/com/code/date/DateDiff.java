package com.code.date;

import java.util.Date;

/**
 * Created by WANG on 2018/8/29.
 */
public class DateDiff {



    public static void main(String[] args) {

        DateUtil.parse("2018-8-29 16:33:20");
        System.out.println(getDatePoor(DateUtil.parse("2018-08-29 16:35:20"),new Date()));

        long diff = DateUtil.parse("2018-08-29 16:38:00").getTime() - new Date().getTime();
        System.out.println("相差" + (diff / 1000) + "秒");
        System.out.println(new Date(1535533104032L));

    }

    public static String getDatePoor(Date endDate, Date nowDate) {

        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

}
