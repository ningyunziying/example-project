package com.ny.example.concurrency.delay_queue;

import java.util.Date;
import java.util.concurrent.DelayQueue;

public class DelayTask implements Runnable {
    private int id;
    private DelayQueue<DelayEvent> queue;

    public DelayTask(int id, DelayQueue<DelayEvent> queue) {
        super();
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + id * 1000);
        System.out.println("Thread " + id + " " + delay);
        for (int i = 0; i < 100; i++) {
            DelayEvent delayEvent = new DelayEvent(delay);
            queue.add(delayEvent);
        }
    }
}
