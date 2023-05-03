package com.mieker.kafkaadminclient.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestController
@Slf4j
@RequiredArgsConstructor
public class AdminClientController {

    private final AdminClient adminClient;

    @PostMapping("/create-topic")
    public ModelAndView createTopic(
            @RequestParam String topicName, @RequestParam int partitionsNumber, @RequestParam short replicasNumber)
            throws ExecutionException, InterruptedException {

        NewTopic thirdTopic = new NewTopic(topicName, partitionsNumber, replicasNumber);
        adminClient.createTopics(List.of(thirdTopic)).all().get();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("successMessage", "Topic " + topicName + " created!");

        return modelAndView;
    }

    @PostMapping("/delete-topic")
    public String deleteTopic(@RequestParam String topicName) {

        //TODO: implementation of deleting topics here

        //adminClient.deleteTopics(Collections.singleton("third_topic"));

        return null;
    }

    private void logAllTopics() throws ExecutionException, InterruptedException {
        Set<String> topics = adminClient.listTopics().names().get();
        topics.forEach(log::info);
    }

}
