package com.ny.example.jdk8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class LambdaTest {
    public int add(int x, int y) {
        return x + y;
    }
    public static void main(String[] args) {
        Runnable r1 = () -> {System.out.println("Hello Lambda!");};
        Map map = new HashMap();
        map.put("k","v");
        map.forEach((o,v)->{
            System.out.println(o);
            System.out.println(v);
        });
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("k","v");
        map.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v);
        });

        Stream.generate(Math::random).limit(5).forEach(System.out::println);

    }
}
