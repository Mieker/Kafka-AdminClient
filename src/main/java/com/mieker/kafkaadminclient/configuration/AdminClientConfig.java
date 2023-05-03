package com.mieker.kafkaadminclient.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class AdminClientConfig {

    @Bean
    public AdminClient adminClient() {
        Properties properties = new Properties();
        properties.put(org.apache.kafka.clients.admin.AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        return AdminClient.create(properties);
    }

}
