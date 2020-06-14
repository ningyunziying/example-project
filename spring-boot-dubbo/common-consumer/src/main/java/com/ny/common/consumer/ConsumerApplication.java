package com.ny.common.consumer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.swing.*;

@SpringBootApplication
public class ConsumerApplication implements CommandLineRunner {
    @Resource
    ConsumerService consumerService;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(consumerService.getName());
    }
}
