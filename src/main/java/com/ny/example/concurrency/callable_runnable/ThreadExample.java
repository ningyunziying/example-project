package com.ny.example.concurrency.callable_runnable;

public class ThreadExample extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
