package com.ningyunziying.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

@Slf4j
@Component
@EnableScheduling
public class Producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    // @Scheduled(cron = "0/1 * * * * ?")
    public void send() {
        String message = UUID.randomUUID().toString();
        ListenableFuture listenableFuture = kafkaTemplate.send(Topic.SIMPLE, message);
        listenableFuture.addCallback(
                o -> log.info("消息发送成功,{}", o.toString()),
                throwable -> log.info("消息发送失败,{}" + throwable.getMessage())
        );
    }
}
