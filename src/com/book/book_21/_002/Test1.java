package com.book.book_21._002;

import java.util.*;

public class Test1 implements Runnable{

    protected int countDown = 10;
    private static int taskCount = -1;
    private final int id = ++taskCount;
    private static int n = 0;
    private static final List<StringBuilder> LIST = new ArrayList<>();
    public Test1() {
    	LIST.add(new StringBuilder());
    }
    public Test1(int countDown) {
    	this();
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + n++ + " - " + (countDown > 0? countDown : "Liftoff!") + "),";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
        	LIST.get(id).append(status());
            // 该方法的作用是该线程执行完重要的一个步骤了,可以先切换其他线程去运作
            Thread.yield();
        }
        LIST.get(id).append("\r\n");
    }

    
    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            new Thread(new Test1()).start();
        }
        System.out.println(Test1.getString());
    }
    
    public static String getString() {
    	return LIST.toString();
    }
}
