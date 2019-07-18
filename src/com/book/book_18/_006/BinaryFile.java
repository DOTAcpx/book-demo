package com.book.book_18._006;

import java.io.*;

public class BinaryFile {
	
	public static byte[] read(File bFile) throws IOException {
		BufferedInputStream stream = new BufferedInputStream(new FileInputStream(bFile));
		try {
			byte[] resultBytes = new byte[stream.available()];
			stream.read(resultBytes);
			return resultBytes;
		} finally {
			stream.close();
		}
	}

	public static byte[] read(String fileName) throws IOException {
		return read(new File(fileName).getAbsoluteFile());
	}
	
}
