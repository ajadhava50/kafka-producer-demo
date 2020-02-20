package com.example.kafkaproducerdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    final String  ktopic = "demo_topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String msg) {
        kafkaTemplate.send(ktopic, msg);

    }

    @KafkaListener(topics = ktopic)
    public void consume(String msg) {
        System.out.println("received msg from: "+msg);
    }
}
