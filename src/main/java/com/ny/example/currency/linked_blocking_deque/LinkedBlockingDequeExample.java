package com.ny.example.currency.linked_blocking_deque;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque deque = new LinkedBlockingDeque();
        deque.addFirst("1");
        deque.addLast("2");
        System.out.println(deque.takeFirst());
        System.out.println(deque.takeFirst());
    }
}
