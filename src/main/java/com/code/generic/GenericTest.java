package com.code.generic;


import com.code.reflex.Student;

import java.util.HashMap;
import java.util.Map;

public class GenericTest {

    private Map<Class<?>,Object> serviceMap = new HashMap();

    public static void main(String[] args) {
        GenericTest ge = new GenericTest();
        ge.put(Student.class, new Student(12));
        Student st = ge.getService(Student.class);
        System.out.println(st.getAge());
    }


    public <T> T getService(Class cls) {
        return (T) serviceMap.get(cls);
    }


    public void put(Class cls,Object value) {
        serviceMap.put(cls,value);
    }


}
