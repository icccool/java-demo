package com.code.reflex;

import java.lang.reflect.Field;

public class ReflexValue {



    public static void main(String[] args) {

        try {
            Student stu = new Student();
            stu.setAge(12);

            Class clz = Student.class;
            Field[] fs = clz.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                System.out.println(fs[i].getName() + "===>" + fs[i].get(stu));
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
