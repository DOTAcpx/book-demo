package com.book.book_18._010;

import java.nio.charset.Charset;
import java.util.Map;

public class AvailableCharSets {
	public static void main(String[] args) {
		for(Map.Entry<String,Charset> charset : Charset.availableCharsets().entrySet()) {
			
			Charset sonCharset = charset.getValue();
			StringBuilder toString = new StringBuilder(charset.getKey()).append(" : ");
			for(String aliases : sonCharset.aliases()) {
				toString.append(aliases).append(" ");
			}
			System.out.println(toString);
		}
	}
}
