package com.book.book_18._006;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test17 {
	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_006\\Test17.java";
	public static void main(String[] args) {
		TestFile testFile = new TestFile(fileName);
		HashMap<Character,Integer> map = new HashMap<>();
		for (String s : testFile) {
			s.chars().forEach( i -> {
				Integer num = map.get((char)i);
				num = num == null? 1 : num + 1;
				map.put((char)i, num);
			});
		}
		for(Entry<Character,Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + ":" + e.getValue());
		}
	}
}
