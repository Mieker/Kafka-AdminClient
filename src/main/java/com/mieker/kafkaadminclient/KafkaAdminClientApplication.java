package com.mieker.kafkaadminclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
@Slf4j
public class KafkaAdminClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaAdminClientApplication.class, args);
    }

    @Bean
    public AdminClient getAdminClient() {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return AdminClient.create(properties);
    }

}
