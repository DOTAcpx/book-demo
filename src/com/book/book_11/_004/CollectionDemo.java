package com.book.book_11._004;

import java.util.*;

public class CollectionDemo {
	
	public static void main(String[] args) {
		System.out.println("ArrayList:" + add(new ArrayList<String>()));
		System.out.println("LinkedList:" + add(new LinkedList<String>()));
		System.out.println("HashSet(快速的存储和获取):" + add(new HashSet<String>()));
		System.out.println("TreeSet(排序首字符a-z A-Z 0-9排序):" + add(new TreeSet<String>()));
		System.out.println("LinkedHashSet(有顺序的存储和获取):" + add(new LinkedHashSet<String>()));
	}
	
	public static Collection<String> add(Collection <String> collection) {
		collection.add("g1");
		collection.add("s2");
		collection.add("y3");
		collection.add("n4");
		collection.add("a5");
		collection.add("w6");
		collection.add("u7");
		return collection;
	}
}
