package com.book.book_18._010;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class ByteBufferTest {
	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_010\\byeteTest8.txt";
	static String fileEncoding = System.getProperty("file.encoding");
	public static void main(String[] args) throws Exception {
		write();
		read();
	}
	
	private static void read() throws IOException {
		FileInputStream inputStream = new FileInputStream(fileName);
		FileChannel inFc = inputStream.getChannel();
		try {
			ByteBuffer inputByteBuffer = ByteBuffer.allocate(24);
			inFc.read(inputByteBuffer);
			inputByteBuffer.flip();
			String string = new String(inputByteBuffer.array());
			System.out.println(string);
		} finally {
			inFc.close();
			inputStream.close();
		}
	}
	
	private static void write() throws Exception {
		FileOutputStream outputStream = new FileOutputStream(fileName);
		FileChannel outFc = outputStream.getChannel();
		try {
			ByteBuffer test8 = ByteBuffer.wrap("你好阿".getBytes(fileEncoding));
			outFc.write(test8);
		} finally {
			outFc.close();
			outputStream.close();
		}
		
	}
	
}
