package com.book.book_17._002;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Countries {
	public static final String[][] DATA = { { "aa", "AA" }, { "bb", "BB" }, { "cc", "CC" }, { "dd", "DD" },
			{ "ee", "EE" }, { "ff", "FF" }, { "gg", "GG" }, { "hh", "HH" }, { "ii", "II" }, { "jj", "JJ" },
			{ "kk", "KK" }, { "ll", "LL" }, { "mm", "MM" }, { "nn", "NN" }, { "oo", "OO" }, { "pp", "PP" },
			{ "qq", "QQ" }, { "rr", "RR" }, { "ss", "SS" }, { "tt", "TT" }, { "uu", "UU" }, { "vv", "VV" },
			{ "ww", "WW" }, { "xx", "XX" }, { "yy", "YY" }, { "zz", "ZZ" } };

	private static class FlyweightMap extends AbstractMap<String, String> {

		private static class Entry implements Map.Entry<String, String> {
			int index;

			Entry(int index) {
				this.index = index;
			}

			public String getKey() {
				return DATA[index][0];
			}

			public String getValue() {
				return DATA[index][1];
			}

			public String setValue(String value) {
				String returnValue = DATA[index][1];
				DATA[index][1] = value;
				return returnValue;
			}

			public boolean equals(Object o) {
				return DATA[index][0].equals(o);
			}

			public int hashCode() {
				return DATA[index][0].hashCode();
			}
		}

		static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
			private int size;

			EntrySet(int size) {
				if (size < 0)
					this.size = 0;
				else if (size > DATA.length)
					this.size = DATA.length;
				else
					this.size = size;
			}

			public int size() {
				return size;
			}

			private class Iter implements Iterator<Map.Entry<String, String>> {
				private Entry entry = new Entry(-1);

				public boolean hasNext() {
					return entry.index < size - 1;
				}

				public Map.Entry<String, String> next() {
					entry.index++;
					return entry;
				}
			}

			public Iterator<java.util.Map.Entry<String, String>> iterator() {
				return new Iter();
			}
		}

		private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

		@Override
		public Set<Map.Entry<String, String>> entrySet() {
			return entries;
		}
	}

	static Map<String, String> select(final int size) {
		return new FlyweightMap() {
			public Set<Map.Entry<String, String>> entrySet() {
				return new EntrySet(size);
			}
		};
	}

	static Map<String, String> map = new FlyweightMap();

	public static Map<String, String> capitals() {
		return map;
	}

	public static Map<String, String> capitals(int size) {
		return select(size);
	}

	static List<String> names = new ArrayList<String>(map.keySet());

	public static List<String> names() {
		return names;
	};

	public static List<String> names(int size) {
		return new ArrayList<String>(select(size).keySet());
	}

	public static void main(String[] args) {
		// println();
		// 5 101 << 1010
		System.out.println((5 << 1 << 1 >>> 1 >> 1 << 2 ));

	}

	static void println() {
		System.out.println(capitals(10));
		System.out.println(names(10));
		System.out.println(new HashMap<>(capitals(3)));
		System.out.println(new LinkedHashMap<>(capitals(3)));
		System.out.println(new TreeMap<>(capitals(3)));
		System.out.println(new Hashtable<>(capitals(3)));
		System.out.println(new HashSet<>(names(6)));
		System.out.println(new LinkedHashSet<String>(names(6)));
		System.out.println(new TreeSet<>(names(6)));
		System.out.println(new ArrayList<>(names(6)));
		System.out.println(new LinkedList<>(names(6)));
		System.out.println(capitals().get("dd"));
	}
}
