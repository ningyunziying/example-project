package com.ny.example.concurrency.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static class Producer implements Runnable {
        protected BlockingQueue queue = null;

        public Producer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                queue.put("1");
                Thread.sleep(1000);
                queue.put("2");
                Thread.sleep(1000);
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Consumer implements Runnable {
        protected BlockingQueue queue = null;

        public Consumer(BlockingQueue queue) {
            this.queue = queue;
        }

        public void run() {
            try {
                System.out.println(queue.take());
                System.out.println(queue.take());
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static BlockingQueue queue = new ArrayBlockingQueue(1024);

    static Producer producer = new Producer(queue);
    static Consumer consumer = new Consumer(queue);

    public static void main(String[] args) throws Exception {


        new Thread(producer).start();
        new Thread(consumer).start();

        Thread.sleep(4000);
    }
}
