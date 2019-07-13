package com.book.book_11._010;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Test_21 {
	private static Test_21 test = new Test_21();
	public static void main(String[] args) {
		test.put();
	}
	
	public void put() {
		Random ran = new Random(47);
		Map<String,Integer> map = new HashMap<>();
		//map.putAll();
		for(int i=0;i<100000;i++) {
			Integer num = map.get(String.valueOf((char)(ran.nextInt(74)+48)));
			map.put(String.valueOf((char)(ran.nextInt(74)+48)), num==null?1:++num);
		}
		print(map);
		
		System.out.println("------------华丽的分割线------------");
//		Collections.sort(map,String.CASE_INSENSITIVE_ORDER);
	}
	
	public void print(Map <String,Integer> map) {
		for(String key:map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
	}
}
