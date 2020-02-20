package com.code.date;

import java.util.Date;

/**
 * Created by WANG on 2018/8/29.
 */
public class DateDiff {

    static long nd = 1000 * 24 * 60 * 60;
    static long nh = 1000 * 60 * 60;
    static long nm = 1000 * 60;

    public static void main(String[] args) {
        Date compareDate = DateUtil.parse("2019-11-05 16:38:00");
        Date currentDate = new Date();
        long diff = currentDate.getTime() - compareDate.getTime();
        System.out.println("相差" + (diff / 1000) + "秒");
        System.out.println("相差" + (diff / nd) + "天");
        if ((diff / nd) > -1) {
            System.out.println("未到有效期");
        } else {
            System.out.println("到有效期");
        }
    }

    public static String getDatePoor(Date endDate, Date nowDate) {
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
