package com.mieker.kafkaadminclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Slf4j
public class KafkaAdminClientApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(KafkaAdminClientApplication.class, args);

        Set<String> topics = adminClient.listTopics().names().get();

        for (String topic : topics) {
            log.info(topic);
        }

//        NewTopic thirdTopic = new NewTopic("third_topic", 3, (short) 1);
//
//        adminClient.createTopics(List.of(thirdTopic)).all().get();
//
//        for (String topic : topics) {
//            log.info(topic);
//        }

//        adminClient.deleteTopics(Collections.singleton("third_topic"));
//
//        for (String topic : topics) {
//            log.info(topic);
//        }
    }

    @Bean
    public AdminClient getAdminClient() {

        //TODO: setup Bean for controller to extract variables to create new topics
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return AdminClient.create(properties);
    }

}
