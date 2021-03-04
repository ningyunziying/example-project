package com.ny.example.concurrency.callable_runnable;

import java.util.concurrent.FutureTask;

public class CallableAndRunnable {
    //    static class CallableExample implements Callable{
//        @Override
//        public Object call() {
//            System.out.println("dd");
//            System.out.println(Thread.currentThread().getId());
//            return null;
//        }
//    }
//    static class RunnableExample implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getId());
//        }
//    }
//    static class ThreadExample extends Thread{
//
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getId());
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println(Thread.currentThread().getId());
//        CallableExample example = new CallableExample();
//        example.call();
//        RunnableExample runnableExample = new RunnableExample();
//        runnableExample.run();
//        ThreadExample threadExample = new ThreadExample();
//        threadExample.run();
//    }
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getId());
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
        new Thread(new RunnableExample()).start();
        CallableExample callableExample = new CallableExample();
        FutureTask<String> task = new FutureTask<>(callableExample);
        task.run();
    }
}
