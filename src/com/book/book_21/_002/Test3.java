package com.book.book_21._002;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
	
	public static void main(String[] args) throws Exception {
		cachedThreadTest();
		fixedThreadTest();
		singleThreadTest();
		System.out.println(Test1.getString());
		Thread.sleep(1000L);
		System.out.println(Test1.getString());
	}
	
	// 线程数由类自动定义,执行方法
	public static void cachedThreadTest() {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++) {
			cachedThreadPool.execute(new Test1());
		}
		// 执行shutdown后,之后使用该类执行多线程则不会产生效果
		cachedThreadPool.shutdown();
	}

	// 需指定特定的线程数,之后使用这些线程数执行方法
	public static void fixedThreadTest() {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
		for(int i = 0; i < 5; i++) {
			fixedThreadPool.execute(new Test1());
		}
		// 执行shutdown后,之后使用该类执行多线程则不会产生效果
		fixedThreadPool.shutdown();
	}
	
	// 该测试类似于Executors.newFixedThreadPool(1)的创建
	// 该类只会开启单一线程执行方法,如果过多执行就在那些先挂起,往后再执行
	public static void singleThreadTest() {
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		for(int i = 0; i < 5; i++) {
			singleThreadExecutor.execute(new Test1());
		}
		// 执行shutdown后,之后使用该类执行多线程则不会产生效果
		singleThreadExecutor.shutdown();
	}
}
