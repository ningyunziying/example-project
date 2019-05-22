package com.ny.example.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantLockExample reentrantLockExample = new ReentrantLockExample();

        for (int i = 0; i < 500; i++) {
            Thread  runnable =  new Thread(() -> {
                reentrantLockExample.doWork("1");
                reentrantLockExample.doWork("2");
            });
            runnable.start();
            System.out.println("完毕～");
        }
    }

    public void doWork(String id) {
        lock.lock();
        System.out.println("lock" + Thread.currentThread().getId() + id);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
