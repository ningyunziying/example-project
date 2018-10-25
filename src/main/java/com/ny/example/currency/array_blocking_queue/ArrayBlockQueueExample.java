package com.ny.example.currency.array_blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayBlockQueueExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue queue = new ArrayBlockingQueue(1024);

        queue.put("1");

       // Object object = queue.take();
        queue.element();
        System.out.println(queue.size());
    }
}
