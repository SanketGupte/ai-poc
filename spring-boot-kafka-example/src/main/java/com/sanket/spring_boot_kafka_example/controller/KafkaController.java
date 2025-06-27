package com.sanket.spring_boot_kafka_example.controller;

import com.sanket.spring_boot_kafka_example.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message){
        kafkaProducerService.sendMessage(message);
        return "Message Sent Successfully";
    }

}
