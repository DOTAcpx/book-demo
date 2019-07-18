package com.book.book_18._008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		String s;
		while((s = reader.readLine()) != null && s.length() != 0) {
			writer.print(s.toUpperCase() + "\n");
			writer.flush();
		}
	}
}
