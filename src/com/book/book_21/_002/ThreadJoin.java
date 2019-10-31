package com.book.book_21._002;

public class ThreadJoin implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		Thread not = new Thread(new ThreadJoin());
		Thread have = new Thread(new ThreadJoin(999999));
		not.start();
		have.join();
	}
	
	@Override public void run() {
		try {
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int i = 10;
	ThreadJoin(int i){
		this.i = i;
		run();
	}
	ThreadJoin(){}
	int getI() { return i; }
	@Override public String toString() { return String.valueOf(i); }
}
