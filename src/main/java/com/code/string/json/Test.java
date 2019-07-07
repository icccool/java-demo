package com.code.string.json;

import com.alibaba.fastjson.JSONObject;


import java.util.Arrays;
import java.util.List;

/**
 * Created by john on 17/9/23.
 */
public class Test {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        List strings1 = Arrays.asList(new String[]{"a", "b"});
        List strings2 = Arrays.asList(new String[]{"c", "d"});
        String str = JsonUtil.objectToString(new List[]{strings1, strings2});
        List ls = (List) JsonUtil.stringToObject(str, List.class);
        System.out.println(str);
        System.out.println(ls);
    }

}

