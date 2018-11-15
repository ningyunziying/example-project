package com.ny.example.currency.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(5,true);
        for (int i = 0; i < 20; i++) {
            final long num = i;
            executorService.execute(() -> {
                try {
                    //获取许可
                    semaphore.acquire();
                    System.out.println("Accessing: " + num);
                    //模拟执行时间
                    Thread.sleep(new Random().nextInt(10000));
                    //释放
                    semaphore.release();
                    //打印释放
                    System.out.println("Release...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        //退出线程池
        executorService.shutdown();
    }
}
