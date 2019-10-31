package com.jdk_8.stream;

import java.util.*;

public class ComparatorTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("cba", "ccs", "asb", "asc2", "ade");
		Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(String.CASE_INSENSITIVE_ORDER));
		Collections.sort(list, Comparator.comparingInt( (String s) -> s.length()).reversed());
//		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(list);
	}
	
}
