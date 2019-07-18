package com.book.book_18._006;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class Test19 {

	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_006\\Test19.java";
	
	public static void main(String[] args) throws IOException {
		byte[] read = BinaryFile.read(fileName);
		HashMap<Byte,Integer> printMap = new HashMap<>();
		for (byte b : read) {
			Integer num = printMap.get(b);
			num = num == null ? 1 : num;
			printMap.put(b, ++num);
		}
		for (Entry<Byte,Integer> e : printMap.entrySet()) {
			Byte b = e.getKey();
			System.out.println((char)(int)b + ":" + e.getValue());
		}
	}
}
