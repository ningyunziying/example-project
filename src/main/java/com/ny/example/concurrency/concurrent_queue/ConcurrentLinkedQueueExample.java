package com.ny.example.concurrency.concurrent_queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        for(long i = 0;i<Long.MAX_VALUE;i++){
            queue.add(String.valueOf(i));
        }
        System.out.println(queue.size());
    }
}
