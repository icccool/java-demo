package com.code.reflex.enums;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author WANG JI BO
 * @Date 2019/8/8 下午2:25
 * @Description
 **/
public class Test {

    public static void main(String[] args) {
        try {
            //反射获取枚举类
            System.out.println(getOptionSetEnums("com.code.reflex.enums.DocumentStatusEnum"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getOptionSetEnums(String className) throws Exception {
        // 得到枚举类对象
        Class<Enum> clazz = (Class<Enum>) Class.forName(className);
        System.out.println(clazz.getName());
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Enum[] enumConstants = clazz.getEnumConstants();
        Method getValue = clazz.getMethod("getValue");
        Method getName = clazz.getMethod("getName");
        Map<String, Object> map = null;
        for (Enum em : enumConstants) {
            map = new HashMap<String, Object>();
            map.put("value", getValue.invoke(em));
            map.put("name", getName.invoke(em));
            list.add(map);
        }
        return list;
    }


}
