package com.service.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class JsonObjectSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONObjectByMap();

	}

//	{
//		"name":"王小二",
//		"age":25,
//		"birthday":"1900-12-20",
//		"school":"蓝翔",
//		"major":[
//		         "理发","挖掘机"
//		         ],
//		"has girlfriend":false,
//		"car":null,
//		"comment":"这是一个注释"
//		
//	}
	private static void JSONObject() {
		JSONObject wangxiaoer = new JSONObject();
		wangxiaoer.put("name", "王小二");
		wangxiaoer.put("age", 25);
		wangxiaoer.put("birthday", "1900-12-20");
		wangxiaoer.put("school", "蓝翔");
		wangxiaoer.put("major", new String[]{"理发","挖掘机"});
		wangxiaoer.put("has girlfriend", false);
		wangxiaoer.put("car", null);
		wangxiaoer.put("comment", "这是一个注释");
		
		System.out.println(wangxiaoer.toString());
	}
	
	private static void JSONObjectByMap(){
		Map<String, Object> wangxiaoer = new HashMap<String, Object>();
		wangxiaoer.put("name", "王小二");
		wangxiaoer.put("age", 25);
		wangxiaoer.put("birthday", "1900-12-20");
		wangxiaoer.put("school", "蓝翔");
		wangxiaoer.put("major", new String[]{"理发","挖掘机"});
		wangxiaoer.put("has girlfriend", false);
		wangxiaoer.put("car", null);
		wangxiaoer.put("comment", "这是一个注释");
		
		JSONObject json = new JSONObject();
		System.out.println(new com.alibaba.fastjson.JSONObject(wangxiaoer));
	}

}
