package com.book.book_11._012;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Test_30 implements Collection<Character>{
	
	private char [] c = "<span class=\"weather-city\"><em>广州 <a href=\"#\" class=\"sets\">[更改]</a></em><a href=\"http://tianqi.sogou.com/guangzhou/\" target=\"_blank\">七日天气</a></span>".toCharArray();
	
	@Override
	public int size() {
		return c.length;
	}

	@Override
	public boolean isEmpty() {
		return c == null || c.length == 0;
	}

	@Override
	public boolean contains(Object c) {
		
		return false;
	}

	@Override
	public Iterator<Character> iterator() {
		return new Iterator<Character>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < c.length;
			}

			@Override
			public Character next() {
				return c[index++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		int size = size();
		Object [] o = new Object[size];
		Iterator<Character> iterator = iterator();
		for(int i = 0 ;i<size;i++) {
			if(iterator.hasNext()) {
				o[i]= iterator.next();
			}else {
				return Arrays.copyOf(o,size);
			}
		}
		return o;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return a;
	}

	@Override
	public boolean add(Character e) {
		return false;
	}

	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Character> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
