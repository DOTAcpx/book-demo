package com.book.book_18._010;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class CharBufferTest {

	public static void main(String[] args) {
		CharBuffer charBuffer = ByteBuffer.allocate(16).asCharBuffer();
		charBuffer.put("abcdefgh".toCharArray());
		charBuffer.rewind();
		System.out.println(charBuffer);
		reset(charBuffer);
		charBuffer.rewind();
		System.out.println(charBuffer);
		System.out.println("-------------------");
		charBuffer.rewind();
		System.out.println(charBuffer);
		
	}
	
	public static void reset(CharBuffer charBuffer) {
		while(charBuffer.hasRemaining()) {
			charBuffer.mark();
			char one = charBuffer.get();
			char two = charBuffer.get();
			charBuffer.reset();
			charBuffer.put(two);
			charBuffer.put(one);
		}
		
	}
	
}
