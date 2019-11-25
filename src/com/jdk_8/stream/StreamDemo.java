package com.jdk_8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

public class StreamDemo {
	static StreamDemo demo = new StreamDemo();
	
	public static void main(String[] args) {
		demo.streamRangeTest();
	}
	
	public void streamRangeTest() {
		List<String> list = Arrays.asList("1", "2", "3", "4");
		IntStream.range(0, list.size()).forEach(i -> {
			System.out.println(list.get(i));
		});
		
		String str = list.stream().map(i -> i += "5" ).reduce("1", (a, b) -> a + "-" + b + " ");
		System.out.println(str);
		
	}
}
