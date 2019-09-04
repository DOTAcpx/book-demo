package com.book.book_21._002;

public class Test2 implements Runnable{
    static int oldValue = 1;
    static int nowValue = 1;
    Test2(){
        int newValue = oldValue;
        oldValue = nowValue;
        nowValue += newValue;
        System.out.println(nowValue);
    }

    @Override
    public void run() {
        new Test2();
    }
    static Test2 test2 = new Test2();
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(test2).start();
        }
    }
}
