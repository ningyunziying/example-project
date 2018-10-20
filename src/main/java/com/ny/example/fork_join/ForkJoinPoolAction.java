package com.ny.example.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkJoinPoolAction {
    public static void main(String[] args) throws InterruptedException {
        PrintTask task  = new PrintTask(0,100);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
