package com.example.kafkaproducerdemo.resource;

import com.example.kafkaproducerdemo.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaResource {

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/send/{msg}")
    public String sendMsg(@PathVariable String msg){

        kafkaService.send(msg);
        return "msg send to kafka";
    }
}
