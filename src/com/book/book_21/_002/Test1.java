package com.book.book_21._002;

public class Test1 implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public Test1() {}
    public Test1(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0? countDown : "Liftoff!") + "),";
    }

    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.print(status());
            // 该方法的作用是该线程执行完重要的一个步骤了,可以先切换其他线程去运作
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2 ; i++) {
            new Thread(new Test1()).start();
        }
    }
}
