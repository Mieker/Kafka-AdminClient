package com.mieker.kafkaadminclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Slf4j
public class KafkaAdminClientApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(KafkaAdminClientApplication.class, args);

//        adminClient.deleteTopics(Collections.singleton("third_topic"));
//
//        for (String topic : topics) {
//            log.info(topic);
//        }
    }

    @Bean
    public AdminClient getAdminClient() {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return AdminClient.create(properties);
    }

}
