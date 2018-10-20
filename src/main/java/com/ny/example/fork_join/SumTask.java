package com.ny.example.fork_join;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 20; //每个小任务 最多只累加20个数
    private int arr[];
    private int start;
    private int end;

    /**
     * Creates a new instance of SumTask.
     * 累加从start到end的arr数组
     *
     * @param arr
     * @param start
     * @param end
     */
    public SumTask(int[] arr, int start, int end) {
        super();
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        //当end与start之间的差小于threshold时，开始进行实际的累加
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {//当end与start之间的差大于threshold，即要累加的数超过20个时候，将大任务分解成小任务
            int middle = (start + end) / 2;
            SumTask left = new SumTask(arr, start, middle);
            SumTask right = new SumTask(arr, middle, end);
            //并行执行两个 小任务
            left.fork();
            right.fork();
            invokeAll(left, right);
            //把两个小任务累加的结果合并起来
            return left.join() + right.join();
        }
    }
}
