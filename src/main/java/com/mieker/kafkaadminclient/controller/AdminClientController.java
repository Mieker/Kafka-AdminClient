package com.mieker.kafkaadminclient.controller;

import com.mieker.kafkaadminclient.service.AdminClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Controller
@RequiredArgsConstructor
public class AdminClientController {

    private final AdminClientService adminClientService;

    @GetMapping("/")
    public String getAllTopics(Model model) throws ExecutionException, InterruptedException {
        Set<String> topics = adminClientService.getAllTopics();
        model.addAttribute("topics", topics);
        return "index";
    }

    @PostMapping("/create-topic")
    public String createTopic(
            RedirectAttributes redirectAttributes,
            @RequestParam String topicName, @RequestParam int partitionsNumber, @RequestParam short replicasNumber)
            throws ExecutionException, InterruptedException {

        adminClientService.createTopic(topicName, partitionsNumber, replicasNumber);
        redirectAttributes.addFlashAttribute("successMessage", "Topic " + topicName + " created!");
        return "redirect:";
    }

}
