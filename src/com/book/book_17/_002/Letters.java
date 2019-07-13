package com.book.book_17._002;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Letters implements Iterable<Integer>{
	private int size = 9;
	private int number = 1;
	private char letter = 'A';
	private String a = "a";
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			public Integer next() {
				a = "b";
				number = 4;
				return number++; 
			}
			@Override
			public boolean hasNext() {
				return number < size;
			};
			
		};
	}

}
