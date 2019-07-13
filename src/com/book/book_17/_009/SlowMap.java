package com.book.book_17._009;

import java.util.*;

import com.book.book_17._002.Countries;

public class SlowMap<K, V> extends AbstractMap<K, V>{
	private List<K> keyList = new ArrayList<>();
	private List<V> valueList = new ArrayList<>();
	
	public V put(K key,V value) {
		int i = keyList.indexOf(key);
		V oldV = null;
		if(i != -1) {
			oldV = valueList.get(i);
			valueList.set(i, value);
		}else {
			keyList.add(key);
			valueList.add(value);
		}
		return oldV;
	}
	
	public V get(Object key) {
		int i = keyList.indexOf(key);
		V oldV = null;
		if(i != -1) {
			oldV = valueList.get(i);
		}
		return oldV;
	}
	
//	@Override
//	public Set<Entry<K, V>> entrySet() {
//		HashSet<Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>();
//		Iterator<K> keyIterator = keyList.iterator();
//		Iterator<V> valueIterator = valueList.iterator();
//		while(keyIterator.hasNext()) {
//			entrySet.add(new MapEntry<K, V>(keyIterator.next(),valueIterator.next()));
//		}
//		return entrySet;
//	}
	
	@Override
	public Set<Entry<K, V>> entrySet() {
		HashSet<Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>();
		for(int i = 0; keyList.size() > i; i++)
		entrySet.add(new MyMapEntry<K, V>(keyList,valueList,i));
		return entrySet;
	}

	static class MapEntry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		public MapEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		@Override
		public K getKey() { return key; }
		@Override
		public V getValue() { return value; }
		@Override
		public V setValue(V value) { return this.value = value; }
		@Override
		public String toString() {
			return key + " : " + value;
		}
	}

	static class MyMapEntry<K, V> implements Map.Entry<K, V> {
		private List<K> keyList;
		private List<V> valueList;
		private K key;
		private V value;
		private int index;
		public MyMapEntry(List<K> keyList, List<V> valueList, int index) {
			this.keyList = keyList;
			this.valueList = valueList;
			this.key = keyList.get(index);
			this.value = valueList.get(index);
			this.index = index;
		}
		@Override
		public K getKey() { return key; }
		@Override
		public V getValue() { return value; }
		@Override
		public V setValue(V value) { 
			valueList.set(index, value);
			return this.value = value; 
		}
		@Override
		public String toString() {
			return key + " : " + value;
		}
	}
	
	public static void main(String[] args) throws Exception {
		SlowMap<String, String> slowMap = SlowMap.class.newInstance();
		slowMap.putAll(Countries.capitals(10));
		Set<Entry<String, String>> entrySet = slowMap.entrySet();
		Entry<String, String> next = entrySet.iterator().next();
		System.out.println(next);
		System.out.println(entrySet);
		System.out.println(slowMap);
		next.setValue(123 + "");
		System.out.println("-----------------------------");
		System.out.println(next);
		System.out.println(entrySet);
		System.out.println(slowMap);
	}
}
