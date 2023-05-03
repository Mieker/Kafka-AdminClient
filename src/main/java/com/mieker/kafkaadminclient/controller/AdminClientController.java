package com.mieker.kafkaadminclient.controller;

import com.mieker.kafkaadminclient.service.AdminClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class AdminClientController {

    private final AdminClientService adminClientService;

    @PostMapping("/create-topic")
    public ModelAndView createTopic(
            @RequestParam String topicName, @RequestParam int partitionsNumber, @RequestParam short replicasNumber)
            throws ExecutionException, InterruptedException {

        return adminClientService.createTopic(
                topicName,
                partitionsNumber,
                replicasNumber
        );
    }

    @PostMapping("/delete-topic")
    public ModelAndView deleteTopic(@RequestParam String topicName) {
        return adminClientService.deleteTopic(topicName);
    }


}
