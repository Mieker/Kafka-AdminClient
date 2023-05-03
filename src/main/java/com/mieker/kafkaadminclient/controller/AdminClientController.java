package com.mieker.kafkaadminclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AdminClientController {

    @PostMapping("/submit")
    public String submitForm(@RequestParam String stringValue, @RequestParam int intValue, @RequestParam short shortValue) {
        // tutaj możesz wykonać dowolną logikę biznesową z otrzymanymi wartościami

        log.info(stringValue + intValue + shortValue);
        return "success"; // zwrócenie widoku potwierdzającego, że formularz został wysłany
    }

}
