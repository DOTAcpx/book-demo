package com.book.book_18._010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFc {
	static String fileName = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_010\\" + "testFc.txt";
	public static void main(String[] args) throws IOException {
		FileChannel fc;
		FileOutputStream output = new FileOutputStream(fileName);
		fc = output.getChannel();
		String fileEncoding = System.getProperty("file.encoding");
		ByteBuffer outBuff = ByteBuffer.wrap("abcd".getBytes(fileEncoding));
		fc.write(outBuff);
		output.close();
		fc.close();
		
		ByteBuffer inputBuff = ByteBuffer.allocate(24);
		FileInputStream input = new FileInputStream(fileName);
		fc = input.getChannel();
		fc.read(inputBuff);
		int limit = inputBuff.limit();
		System.out.println("limit : " + limit);
		fc.close();
		input.close();
		inputBuff.flip();
		byte[] array = inputBuff.array();
		for (byte c : array) {
			System.out.println((char)c);
		}
	}
}
