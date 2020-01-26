package com.example.demo.aop;

import com.example.demo.aop.AuditLog;
import org.springframework.stereotype.Service;

@Service
public class AopService {
    @AuditLog(title = "dfd")
    public void sing(String name) {
        System.out.println("sing" + name);
    }
}
