package com.book.book_18._006;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TestFile extends ArrayList<String>{
	private static final long serialVersionUID = 1L;

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			String s;
			try {
				while((s = in.readLine()) != null) {
					sb.append(s).append("\n");
				}
			} finally {
				in.close();
			}
		} catch (Exception e) {
		}
		return sb.toString();
	}

	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (Exception e) {
		}
	}
	
	public TestFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		if("".equals(get(0))) remove(0);
	}
	
	public TestFile(String fileName) {
		this(fileName, "\n");
	}
	
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (Exception e) {
		}
	}
	public static void main(String[] args) {
		
	}
	
	
}
