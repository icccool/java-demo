package com.code.string.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtil {

	public static String objectToString(Object obj){
        if (obj == null) return "";
        try {
            return JSON.toJSONString(obj, false);
        } catch (Exception e) {
            return null;
        }
	}

	public static Object stringToObject(String json,Class cls){
		try{
		if(json==null) return null;
			return JSON.parseObject(json,cls);
		}catch(Exception e){
			System.out.println(json);
			e.printStackTrace();
			return null;
		}
	}
	
	public  static <T> T stringToRealObject(String jsonString, Class<T> clazz){
		
		if(jsonString==null) return null;
		
		try{
			return JSON.parseObject(jsonString, new TypeReference<T>(){});
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public  static <T> T stringToTypeReference(String jsonString, TypeReference<T> type){
		
		if(jsonString==null||type==null) return null;
		
		try{
			return JSON.parseObject(jsonString, type);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
}
