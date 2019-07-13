package com.book.book_17._005;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		boolean trueBoolean = false;
		trueBoolean |= true;
		trueBoolean |= false;
		boolean falseBoolean = true;
		falseBoolean &= false;
		falseBoolean &= false;
		System.out.println(falseBoolean);
		System.out.println(trueBoolean);
//		List<Integer> list = Arrays.asList(2, 3, 4, 7, 12, 652);
//		testCollectionAdd(Arrays.asList(2, 3, 4, 7, 12, 652));
//		testCollectionAdd(list);
		
	}
	
	static void testCollectionAdd(Collection<Integer> c) {
		Collections.addAll(c, 2, 3, 4);
		System.out.println(c);
	}
	
}
