package com.book.book_21._003;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable{

	private int i = 0;
	public int getValue() { return i; }
	private synchronized void evenIncrement() { i++;i++;}
	@Override public void run() {
		while(true) evenIncrement();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest atomicityTest = new AtomicityTest();
		exec.execute(atomicityTest);
		int stopValue;
		while(true) {
			stopValue = atomicityTest.getValue();
			if(stopValue % 2 != 0) { exec.shutdown();break; }
		}
		System.out.println("i : " + stopValue);
		System.exit(0);
	}
}
