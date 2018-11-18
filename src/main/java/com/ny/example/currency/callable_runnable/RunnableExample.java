package com.ny.example.currency.callable_runnable;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
