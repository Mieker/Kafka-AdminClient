package com.mieker.kafkaadminclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class KafkaAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAdminClientApplication.class, args);
    }

}
