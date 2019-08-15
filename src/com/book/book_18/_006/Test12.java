package com.book.book_18._006;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.IntStream;

public class Test12 {
	static Test12 test = new Test12();
	
	public static void main(String[] args) throws Exception {
		LinkedList<String> buffList = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
//		writerListOnFile(list);
//		nowBuffWriterListOnFile(list);

		testTime(getMethod("readerFileOnList", List.class), getMethod("writerListOnFile", List.class), buffList);
		testTime(getMethod("notBuffReaderFileOnList", StringBuilder.class), getMethod("nowBuffWriterListOnFile", StringBuilder.class), sb);
	}
	
	public static Method getMethod(String methodName, Class<?>... clazz) throws Exception {
		return test.getClass().getMethod(methodName, clazz);
	}

	public static void testTime(Method readerMethod, Method writerMethod, Object...obj) throws Exception {
		long startTime = System.currentTimeMillis();
		readerMethod.invoke(test, obj);
		writerMethod.invoke(test, obj);
		System.out.println(writerMethod.getName() + " : " + (System.currentTimeMillis() - startTime) + "ss");
	}
	
	public static void nowBuffWriterListOnFile(StringBuilder sb) throws Exception {
		
		FileWriter writerFile = new FileWriter(WRITER_FILE_PATH);
		try {
			IntStream chars = sb.chars();
			chars.forEach( c -> {
				try {
					writerFile.write((char)c);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		} finally {
			writerFile.close();
		}
	}
	
	public static void writerListOnFile(List<String> list) throws Exception {
		BufferedWriter writerFile = new BufferedWriter(new FileWriter(WRITER_FILE_PATH));
		try {
			for(String str : list) {
				writerFile.write(str + "\r\n");
			}
		} finally {
			writerFile.close();
		}
	}

	public static void notBuffReaderFileOnList(StringBuilder sb) throws IOException {
		FileReader fileReader = new FileReader(READER_FILE_PATH);
		try {
			int c;
			int lineNum = 0;
			sb.append(lineNum++ + " ");
			while((c = fileReader.read()) != -1) {
				sb.append((char)c);
				if((char)c == '\r') {
					sb.append((lineNum++) + " ");
				}
			}
		} finally {
			fileReader.close();
		}
	}
	public static void readerFileOnList(List<String> list) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(READER_FILE_PATH));
		try {
			String s;
			int lineNum = 0;
			while((s = reader.readLine()) != null) {
				list.add((lineNum++) + " " + s);
			}
		} finally {
			reader.close();
		}
	}
	
	static final String WRITER_FILE_PATH = "D:\\Resources\\book-demo\\src\\com\\book\\book_18\\_006\\writer.txt";
	static final String READER_FILE_PATH = "D:\\Resources\\book-demo\\src\\com\\book\\book_18\\_006\\reader.txt";
	static {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static void init() throws IOException {
		File readerFile = new File(READER_FILE_PATH);
		File writerFile = new File(WRITER_FILE_PATH);
		if(!writerFile.exists()) {
			writerFile.createNewFile();
		}
		if(!readerFile.exists()) {
			BufferedWriter writer = null;
			try {
				readerFile.createNewFile();
				writer = new BufferedWriter(new FileWriter(readerFile));
				StringBuilder writerStr = new StringBuilder();
				for(int i = 0; i < 10000; i++) {
					writerStr.append(i);
				}
				for(int i = 0; i < 1000; i++) {
					writer.write(writerStr.toString() + "\r\n");
				}
			} finally {
				if(writer != null) {
					writer.close();
				}
			}
		}
	}
}
