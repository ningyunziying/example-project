package com.example.demo;

import com.example.demo.aop.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    //
//    @Autowired
//    RedisTemplate redisTemplate;
    @Autowired
    AopService bodyService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        bodyService.sing("name");
//        Map map = new HashMap();
//        for (int i = 0; i < 1000; i++) {
//            map.put("k" + i, "v" + i);
//        }
//        redisTemplate.opsForHash().putAll("m", map);
//        redisTemplate.opsForValue().set("mv", map);
//        Long t0 = System.currentTimeMillis();
//        for (int i = 0; i < 30000; i++) {
//            HashMap redisMap = (HashMap) redisTemplate.opsForValue().get("mv");
//            redisMap.get("k1");
//        }
//        Long t1 = System.currentTimeMillis();
//        System.out.println("normal:" + (t1 - t0));
//        for (int i = 0; i < 30000; i++) {
//            redisTemplate.opsForHash().get("m", "k1").toString();
//        }
//        System.out.println("hash:" + (System.currentTimeMillis() - t1));
    }
}
