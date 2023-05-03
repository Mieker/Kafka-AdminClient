package com.mieker.kafkaadminclient.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminClientService {

    private final AdminClient adminClient;

    public ModelAndView createTopic(String topicName, int partitionsNumber, short replicasNumber)
            throws ExecutionException, InterruptedException {

        NewTopic thirdTopic = new NewTopic(topicName, partitionsNumber, replicasNumber);
        adminClient.createTopics(List.of(thirdTopic)).all().get();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("successMessage", "Topic " + topicName + " created!");

        logAllTopics();
        return modelAndView;
    }

    //TODO: implement deleting topics logic here
    public ModelAndView deleteTopic(String topicName) {

        //adminClient.deleteTopics(Collections.singleton("third_topic"));
        return null;
    }

    private void logAllTopics() throws ExecutionException, InterruptedException {
        Set<String> topics = adminClient.listTopics().names().get();
        log.info("Available topics:");
        topics.forEach(log::info);
    }
}
