package com.book.book_17._005;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
	
	public static void main(String[] args) throws Exception {
		test(new HashSet<HashType>(), HashType.class);
		test(new HashSet<TreeType>(), TreeType.class);
		test(new HashSet<SetType>(), SetType.class);
		test(new TreeSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);
		test(new TreeSet<SetType>(), SetType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<TreeType>(), TreeType.class);
		test(new LinkedHashSet<SetType>(), SetType.class);
	}
	
	static <T> void test(Set<T> set, Class<T> clazz) {
		fill(set, clazz);
		fill(set, clazz);
		fill(set, clazz);
		System.out.println(set.getClass().getName() + " and " + clazz.getName() + " : " + set);
	}
	
	static <T> Set<T> fill(Set<T> set, Class<T> clazz) {
		try {
			for(int i = 0; i < 10; i++) {
				set.add(clazz.getConstructor(int.class).newInstance(i));
			}
			return set;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return null;
	}
}

class SetType {
	int i;
	public SetType(int i) {
		this.i = i;
	}
	public boolean equals(Object o) {
		return o instanceof SetType && ((SetType)o).i == this.i;
	}
	public String toString() {
		return "[" + i + "] ";
	}
}

class HashType extends SetType {
	public HashType(int i) { super(i); }
	@Override
	public int hashCode() {return i; }
}

class TreeType extends SetType implements Comparable<SetType> {
	public TreeType(int i) {
		super(i);
	}
	@Override
	public int compareTo(SetType o) {
		return o.i == this.i?0:o.i > this.i?1:-1;
	}
}

