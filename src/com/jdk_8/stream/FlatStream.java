package com.jdk_8.stream;

import java.util.Arrays;
import java.util.List;

public class FlatStream {
	
	public static void main(String[] args) {
		List<String> sayList = Arrays.asList("hi", "hello", "bye");
		List<String> nameList = Arrays.asList("zhangsan", "lisi", "wangwu", "chenyi");
		sayList.stream().flatMap( say -> nameList.stream().map( name -> name + " : " + say)).forEach(System.out::println);
	}
	
}
