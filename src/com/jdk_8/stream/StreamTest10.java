package com.jdk_8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class StreamTest10 {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		for(int i = 0; i < 5000000; i++) {
			list.add(UUID.randomUUID().toString());
		}
		ArrayList<String> stream = new ArrayList<>(list);
		ArrayList<String> parallelStream = new ArrayList<>(list);
		long startTime = System.nanoTime();
		stream.stream().sorted().limit(15).forEach(System.out::println);
		long endTime = System.nanoTime();
		long seconds = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("耗时 : " + seconds);
		
		startTime = System.nanoTime();
		parallelStream.parallelStream().sorted().limit(15).forEach(System.out::println);
		endTime = System.nanoTime();
		seconds = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("耗时 : " + seconds);
	}
	
}
