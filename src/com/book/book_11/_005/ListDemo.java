package com.book.book_11._005;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo {
	public static void main(String[] args) {
		List<Integer> list = get();
		List<Integer> sonList = list.subList(2,6);
		print(list);
		print(sonList);
		System.out.println("---------华丽的分割线---------");
//		Collections.sort(list);
//		Collections.shuffle(list);
		print(list);
		print(sonList);
	}
	
	public static void print(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer i = iterator.next();
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static List<Integer> get() {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		return list;
	}
}
