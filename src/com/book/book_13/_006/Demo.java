package com.book.book_13._006;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
	public static void main(String[] args) {
		System.out.println("abcabccabc".replaceAll("abc+","1"));
		Pattern pattern = Pattern.compile("abc+");
		Matcher matcher = pattern.matcher("abcabccabc");
		String replaceAll = matcher.replaceAll("1");
		System.out.println(replaceAll);
	}
}
