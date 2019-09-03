package com.jdk_8.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Test {
	/*
	 * 找出该流中大于2的元素
	 * 然后将每个元素乘以2
	 * 然后忽略掉流中的前两个元素
	 * 然后再取流中的前两个元素
	 * 最后求出流中元素的总和
	 */
	public static void main(String[] args) {
		newTest();
	}
	
	public static void newTest() {
		// 0 1 2 3 4 5 6 7 
		int sum = Stream.iterate(0, i -> i + 1).limit(8).filter(i -> i > 2).mapToInt(i -> i * 2).skip(2).limit(2).sum();
		System.out.println(sum);
	}
	
	public static void oldTest() {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer next = iterator.next();
			if(next <= 2) {
				iterator.remove();
			}
		}
		iterator = list.iterator();
	}
}
