package com.book.book_16._006;

public class TestArray {
	private Byte[] bytes;
	private static int defaultSize = 1000;
	private static int bottleneck = 200;
	private int count = 0;
	public TestArray() {
		init(defaultSize);
	}
	public TestArray(int size) {
		init(size);
	}
	
	public void add(byte b) {
		if(++count > bytes.length - bottleneck) {
			addLength(bytes.length + defaultSize);
		}
		bytes[count] = b;
	}
	
	public void remove() {
		if(count == 0) {
			return;
		}
		bytes[count] = null;
		--count;
	}
	
	private void init(int size) {
		bytes = new Byte[size];
	}
	
	private void addLength(int nextSize) {
		Byte[] oldb = bytes;
		bytes = new Byte[nextSize];
		System.arraycopy(oldb, 0, bytes, 0, nextSize);
	}
}
