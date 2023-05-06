package com.mieker.kafkaadminclient.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminClientService {

    private final AdminClient adminClient;

    public Set<String> getAllTopics() throws ExecutionException, InterruptedException {
        return adminClient.listTopics().names().get();
    }

    public void createTopic(String topicName, int partitionsNumber, short replicasNumber)
            throws ExecutionException, InterruptedException {

        NewTopic thirdTopic = new NewTopic(topicName, partitionsNumber, replicasNumber);
        adminClient.createTopics(List.of(thirdTopic)).all().get();
        logAllTopics();
    }

    public void deleteTopic(String topicName) {
        adminClient.deleteTopics(Collections.singleton(topicName));
    }

    private void logAllTopics() throws ExecutionException, InterruptedException {
        Set<String> topics = adminClient.listTopics().names().get();
        log.info("Available topics:");
        topics.forEach(log::info);
    }
}
