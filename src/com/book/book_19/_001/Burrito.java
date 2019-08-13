package com.book.book_19._001;

import static com.book.book_19._001.Spiciness.*;

public class Burrito {
	Spiciness sp;
	public Burrito(Spiciness sp) {
		this.sp = sp;
	}
	@Override public String toString() { return sp.toString(); }
	public static void main(String[] args) {
		System.out.println(new Burrito(HOT));
		System.out.println(new Burrito(NOT));
		System.out.println(new Burrito(MILD));
	}
}
