package com.book.book_18._006;

import java.io.*;

public class Test15 {
	static String fileName = "D:\\work\\eclipse\\eclipse-workspace\\book-demo\\src\\com\\book\\book_18\\_006\\test15.txt";
	static {
		File file = new File(fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
		DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
		try {
			dataOutputStream.writeUTF("hahaha");
			dataOutputStream.writeDouble(12.12);
			dataOutputStream.writeChars("123123");
			dataOutputStream.writeChar('1');
			dataOutputStream.writeInt(123);
			dataOutputStream.writeLong(321L);
			dataOutputStream.writeBoolean(false);
			dataOutputStream.writeByte(1);
			dataOutputStream.writeBytes("12312");
		} finally {
			dataOutputStream.close();
		}
		try {
//			System.out.println(dataInputStream.readUTF());
//			System.out.println(dataInputStream.readDouble());
//			System.out.println(dataInputStream.readChar());
//			System.out.println(dataInputStream.readChar());
//			System.out.println(dataInputStream.readChar());
//			System.out.println(dataInputStream.readChar());
//			System.out.println(dataInputStream.readChar());
//			System.out.println(dataInputStream.readInt());
//			System.out.println(dataInputStream.readLong());
//			System.out.println(dataInputStream.readBoolean());
			System.out.println(dataInputStream.readUTF());
			System.out.println(dataInputStream.readByte());
			System.out.println(dataInputStream.readByte());
			System.out.println(dataInputStream.readByte());
			int i;
			while((i = dataInputStream.read()) != -1) {
				System.out.println((char)i);
			}
		} finally {
			dataInputStream.close();
		}
	}
}
