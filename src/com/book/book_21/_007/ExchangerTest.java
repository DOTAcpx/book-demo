package com.book.book_21._007;

import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger类通过exchange方法进行类型互换,如果类中不存在互换对象则进入阻塞
 */
public class ExchangerTest {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<S> e = new Exchanger<>();
        S a = new A();
        S b = new B();
        ThreadPoolExecutor exec = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        exec.execute(() -> {
            try {
                S s = e.exchange(a);
                System.out.println("a : " + s);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        exec.execute(() -> {
            try {
                S s = e.exchange(b);
                System.out.println("b : " + s);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

    }


}
interface S {

}
class A implements S{

}
class B implements S{

}