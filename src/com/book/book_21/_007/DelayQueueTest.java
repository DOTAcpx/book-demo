package com.book.book_21._007;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

class DelayedTask implements Runnable, Delayed {

    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;

    protected static List<DelayedTask> sequence = new ArrayList<>();
    public DelayedTask(int delayInMilliseconds){
        delta = delayInMilliseconds;
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delta, TimeUnit.MILLISECONDS);
        sequence.add(this);
    }

    @Override public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override public void run() {
        System.out.println(this + " ");
    }

    @Override public int compareTo(Delayed o) {
        DelayedTask that = (DelayedTask) o;
        return trigger < that.trigger ? -1 : trigger > that.trigger ? 1 : 0;
    }

    @Override public String toString(){ return String.format("[%1$-4d]", delta) + " Task " + id; }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {

        private ExecutorService exec;

        public EndSentinel(int delay, ExecutorService e) {
            super(delay);
            exec = e;
        }

        @Override public void run() {
            for (DelayedTask pt : sequence) {
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    @Override public void run() {
        try {

            while(!Thread.interrupted())
                q.take().run();
        } catch(InterruptedException e){
//            e.printStackTrace();
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}
public class DelayQueueTest {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
//        DelayQueue<DelayedTask> queue = new DelayQueue<>();
//        for (int i = 0; i < 20; i++)
//            queue.put(new DelayedTask(rand.nextInt(5000)));
//        queue.add(new DelayedTask.EndSentinel(5000, exec));
//        exec.execute(new DelayedTaskConsumer(queue));
        DelayQueue<MyDelayed> myQueue = new DelayQueue<>();
        myQueue.put(new MyDelayedEnd(3000, exec));
        for (int i = 0; i < 10; i++) {
            myQueue.put(new MyDelayed(rand.nextInt(3000)));
        }
        exec.execute(() -> {
            MyDelayed take = null;
            try {
                while((take = myQueue.take()) != null){
                    take.run();
                }
            }catch (InterruptedException e){ }
        });
    }

}

class MyDelayed implements Runnable, Delayed{

    private final long delay;

    public MyDelayed(long delay) {
        this.delay = delay + System.nanoTime();
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay  -System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o instanceof MyDelayed){
            MyDelayed myDelayed = (MyDelayed)o;
            return myDelayed.delay > delay ? -1 : myDelayed.delay < delay ? 1 : 0;
        }
        throw new ClassCastException();
    }

    public String toString(){
        return delay + " ";
    }

    @Override
    public void run() {
        System.out.println("执行输出操作 : " + delay);
    }
}
class MyDelayedEnd extends MyDelayed {
    private ExecutorService e;
    public MyDelayedEnd(long delay, ExecutorService e) {
        super(delay);
        this.e = e;
    }
    public void run() {
        System.out.println(" end ");
        e.shutdownNow();
    }
}