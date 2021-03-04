package com.ny.example.concurrency.blocking_queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueExample {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.add("2");
        queue.add("1");
        queue.add("3");
        while (queue.size()!=0){
            System.out.println(queue.take().toString()); ;
        }
    }
}
