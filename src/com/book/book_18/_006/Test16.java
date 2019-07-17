package com.book.book_18._006;

import java.io.*;

public class Test16 {
	
	static String name = System.getProperty("user.dir") + "\\src\\com\\book\\book_18\\_006\\test16.txt";
	/*
		1
		2
		false
		3
		bytes
		c
		chars
		213.231
		2.2
		122
		3
		utf
	 */
	public static void main(String[] args) throws IOException {
		testWriter();
		testReader();
		RandomAccessFile random = new RandomAccessFile(name, "rw");
		
		try {
			random.seek(4*3);
			System.out.println(random.read());
		} finally {
			random.close();
		}
	}
	
	public static void testWriter() throws IOException {
		RandomAccessFile random = new RandomAccessFile(name, "rw");
		try {
			random.writeInt(1);
			random.write(2);
			random.writeBoolean(false);
			random.writeByte(3);
			random.writeBytes("bytes");
			random.writeChar('c');
			random.writeChars("chars");
			random.writeDouble(213.231);
			random.writeFloat(2.2F);
			random.writeLong(122L);
			random.writeShort(3);
			random.writeUTF("utf");
		} finally {
			random.close();
		}
	}
	
	public static void testReader() throws IOException {
		RandomAccessFile random = new RandomAccessFile(name, "r");
		StringBuilder sb = new StringBuilder();
		try {
			sb.append(random.readInt()).append("\n")
			.append(random.read()).append("\n")
			.append(random.readBoolean()).append("\n")
			.append(random.readByte()).append("\n")
			.append((char)random.readByte()).append((char)random.readByte()).append((char)random.readByte()).append((char)random.readByte()).append((char)random.readByte()).append("\n")
			.append((char)random.readChar()).append("\n")
			.append((char)random.readChar()).append((char)random.readChar()).append((char)random.readChar()).append((char)random.readChar()).append((char)random.readChar()).append("\n")
			.append(random.readDouble()).append("\n")
			.append(random.readFloat()).append("\n")
			.append(random.readLong()).append("\n")
			.append(random.readShort()).append("\n")
			.append(random.readUTF()).append("\n");
			System.out.println(sb);
		} finally {
			random.close();
		}
	}
	
}
