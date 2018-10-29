package com.jdk18;

public class TryTest {


    public static void main(String[] args) {
        MyDataSource s1 = null;
        try (MyDataSource s = new MyDataSource(false)) {
            s1 = s;
            System.out.println(s.isClosed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(s1.isClosed);
    }
}
