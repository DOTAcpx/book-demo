package com.book.book_19._005;

import java.util.Random;

public class EnumImplementation {
	enum Cartoon {
		A, B, C, D, E, F, G;
		private Random ran;
		{ ran = new Random(); System.out.println("初始化"); }
		public Cartoon next() {
			return values()[ran.nextInt(values().length)];
		}
	}
	public static void main(String[] args) {
		Cartoon next = Cartoon.A.next();
		System.out.println(next);
		next = Cartoon.A.next();
		System.out.println(next);
	}
	
}
