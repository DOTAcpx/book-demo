package com.book.book_21._007;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.*;

public class SemaphoreTest {
    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
//        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < SIZE; i++) {
//            exec.execute(new CheckoutTask<Fat>(pool));
//        }
//
//        ArrayList<Fat> list = new ArrayList<>();
//        for (int i = 0; i < SIZE; i++) {
//            Fat f = pool.checkOut();
//            System.out.println(i + ": main() thread checked out ");
//            f.operation();
//            list.add(f);
//        }
//
//        Future<?> future = exec.submit(() -> {
//            try {
//                pool.checkOut();
//            } catch (Exception e) {
//                System.out.println("checkOut() Interrupted");
//            }
//        });
//
//        TimeUnit.SECONDS.sleep(2);
//        future.cancel(true);
//        System.out.println("Checking in objects in " + list);
//        for (Fat fat : list) {
//            pool.checkIn(fat);
//        }
//        for (Fat fat : list) {
//            pool.checkIn(fat);
//        }
//        exec.shutdown();

        testSemaphore();
    }
    static int i = 0;
    /**
     * Semaphore类构造器接收一个整形
     * acquire会进行加1操作,如果该值跟传入的参数一致,再使用该方法则进行阻塞
     * release会进行减1操作,如果有进行acquire进行过阻塞,使用该方法将会放行
     */
    public static void testSemaphore() {
        Semaphore s = new Semaphore(3);
        ThreadPoolExecutor exec = new ThreadPoolExecutor(5, 5, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        s.release();
        Runnable run = () -> {
            try {
                s.acquire();
                System.out.println(Thread.currentThread().getName() + " start ");
                TimeUnit.SECONDS.sleep(5);
                s.release();
                System.out.println(Thread.currentThread().getName() + " end ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        exec.execute(run);
        exec.execute(run);
        exec.execute(run);
        exec.execute(run);
        exec.execute(run);
        exec.execute(run);
        exec.execute(run);
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(System.out::println, 0, 1, TimeUnit.SECONDS);
    }
}

class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " checking in " + item);
            pool.checkIn(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return " CheckoutTask " + id + " ";
    }
}

class Fat {
    private volatile double d;
    private static int count;
    private final int id = count++;
    public Fat() {
        for (int i = 0; i < 1000000; i++) {
            d += (Math.PI + Math.E) / i;
        }
    }
    public void operation() {
        System.out.println(this);
    }
    public String toString() {
        return "Fat id : " + id;
    }
}
class Pool<T>{

    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedOut;
    private Semaphore available;
    public Pool(Class<T> classObject, int  size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size, true);
        for (int i = 0; i < size; i++) {
            try {
                items.add(classObject.newInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public T checkOut() throws InterruptedException{
        available.acquire();
        return getItem();
    }

    public void checkIn(T x) {
        if(releaseItem(x)) {
            available.release();
        }
    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if(index == -1) return false;
        if(checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        return false;
    }
}
