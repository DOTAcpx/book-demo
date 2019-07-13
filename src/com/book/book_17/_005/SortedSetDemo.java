package com.book.book_17._005;

import java.util.*;

public class SortedSetDemo {
	public static void main(String[] args) {
		SortedSet<String> set = new TreeSet<String>();
		Collections.addAll(set, "one two three four five six seven eight".split(" "));
		System.out.println(set);
		String low = set.first();
		String high = set.last();
		System.out.println(low);
		
		System.out.println(high);
		Iterator<String> iterator = set.iterator();
		for(int i = 0; i <= 6; i++) {
			if(i == 3)low = iterator.next();
			else if(i == 6)high = iterator.next();
			else iterator.next();
		}
		System.out.println(low);
		System.out.println(high);
		System.out.println(set.headSet(high));
		System.out.println(set.tailSet(low));
		SortedSet<String> subSet = set.subSet(low, high);
		System.out.println(subSet);
		subSet.add("ten");
		System.out.println(set);
	}
}
