package com.book.book_21._002;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test2 implements Callable<Integer>{
	public static final Test2 TEST2 = new Test2();
    static int oldValue = 1;
    static int nowValue = 1;
    Test2(){
        int newValue = oldValue;
        oldValue = nowValue;
        nowValue += newValue;
        System.out.println(nowValue);
    }

    public static void main(String[] args) {
    	List<Future<Integer>> list = new ArrayList<>();
    	ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
        	list.add(executorService.submit(TEST2));
        }
        executorService.shutdown();
        list.forEach(f -> {
        	try {
				System.out.println(f.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
        });
    }

	@Override
	public Integer call() throws Exception {
        int newValue = oldValue;
        oldValue = nowValue;
        nowValue += newValue;
		return nowValue;
	}
}
