package com.book.book_21._008;


import java.util.concurrent.SynchronousQueue;

class Order {
    private static int counter = 0;
    private final int id = counter++;
    private final MyCustomer customer;
    private final WaitPerson waitPerson;
    private final Food food;

    public Order(MyCustomer customer, WaitPerson waitPerson, Food food) {
        this.customer = customer;
        this.waitPerson = waitPerson;
        this.food = food;
    }
}

class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

class MyCustomer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> plates = new SynchronousQueue<>();

    public MyCustomer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate p) throws InterruptedException {
        plates.put(p);
    }

    @Override
    public void run() {
    }
}

class WaitPerson {

}

class Food {

}

public class RestaurantWithQueues {
}
