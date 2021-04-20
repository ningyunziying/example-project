package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Ningning Li
 * 2021/3/9:3:04 PM
 * Description:
 */
@Slf4j
@Service
public class SyncService {
    @Async
    public void too() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("too");
    }
}
