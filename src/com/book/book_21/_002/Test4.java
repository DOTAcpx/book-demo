package com.book.book_21._002;

import static com.book.book_21._002.Test2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test4 {
	
	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Future<Integer> future = executorService.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(5);
					return TEST2.call();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			});
			list.add(future);
		}
		list.forEach(f -> {
			try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		});
		executorService.shutdown();
	}
	
}
