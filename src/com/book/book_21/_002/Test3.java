package com.book.book_21._002;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static com.book.book_21._002.Test2.*;

public class Test3 {
	
	public static void main(String[] args) throws Exception {
//		cachedThreadTest();
//		fixedThreadTest();
//		singleThreadTest();
		cachedThreadSubmitTest();
//		System.out.println(Test1.getString());
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
	
	// 线程数由类自动定义,执行方法
	public static void cachedThreadSubmitTest() {
		List<Future<Integer>> list = new ArrayList<>();
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		
		for(int i = 0; i < 5; i++) {
			list.add(cachedThreadPool.submit(TEST2));
		}
		// 执行shutdown后,之后使用该类执行多线程则不会产生效果
		cachedThreadPool.shutdown();
		list.forEach(f -> {
			try {
				System.out.print(f.get() + " ");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
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
