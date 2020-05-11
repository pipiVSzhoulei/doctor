package com.cy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapTest1 {
public static void main(String[] args) {
	Map<String,Object> map=new HashMap<String,Object>();
	map.put("1", new String("one"));
	map.put("2", new String("two"));
	map.put("3", new String("three"));
	map.forEach((key,value)->{
		System.out.println(key);
		System.out.println(value);
	});
}
}
