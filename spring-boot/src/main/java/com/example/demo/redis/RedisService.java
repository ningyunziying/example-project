package com.example.demo.redis;

import org.springframework.stereotype.Service;

@Service
public class RedisService {
    //    @Autowired
//    RedisTemplate redisTemplate;
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
