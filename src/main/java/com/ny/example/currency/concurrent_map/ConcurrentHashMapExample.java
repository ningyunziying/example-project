package com.ny.example.currency.concurrent_map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        //concurrentHashMap & HashMap
        //cocurrentHashMap & HashTable
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            String ii = String.valueOf(i);
            concurrentHashMap.put(ii,ii);
        }
        System.out.println(System.currentTimeMillis()-t1);
        long t2 = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 10000000; i++) {
            String ii = String.valueOf(i);
            hashMap.put(ii,ii);
        }
        System.out.println(System.currentTimeMillis()-t2);
        //4980
        //3166
    }
}
