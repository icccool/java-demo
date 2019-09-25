package com.code.string.json;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by john on 17/9/23.
 */
public class Test {

    public static void main(String[] args) {

        String jsonStr = "{\"name\":\"d\",\"wareCodes\":[{\"zhangsna\":1},{\"wanger\":2},{\"mazi\":3}]}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String name = jsonObject.getString("name");
        List<Map> list = JSONObject.parseArray(jsonObject.getString("wareCodes"), Map.class);

        List strings1 = Arrays.asList(new String[]{"a", "b"});
        List strings2 = Arrays.asList(new String[]{"c", "d"});
        String str = JsonUtil.objectToString(new List[]{strings1, strings2});
        List ls = (List) JsonUtil.stringToObject(str, List.class);
        System.out.println(str);
        System.out.println(ls);

    }

    public static void main1(@RequestBody  JSONObject jsonObject){
    }


}

