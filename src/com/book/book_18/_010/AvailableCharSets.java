package com.book.book_18._010;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Map;

public class AvailableCharSets {
	public static void main(String[] args) throws Exception {
		FileOutputStream outputStream = new FileOutputStream(TestFc.fileName);
		FileChannel out = outputStream.getChannel();
		for(Map.Entry<String,Charset> charset : Charset.availableCharsets().entrySet()) {
			Charset sonCharset = charset.getValue();
			StringBuilder toString = new StringBuilder(charset.getKey()).append(" : ");
			for(String aliases : sonCharset.aliases()) {
				toString.append(aliases).append(" ");
			}
			System.out.println(toString);
			out.write(ByteBuffer.wrap(toString.append("\n").toString().getBytes(System.getProperty("file.encoding"))));
		}
		out.close();
		outputStream.close();
	}
}
