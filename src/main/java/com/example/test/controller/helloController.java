package com.example.test.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class helloController {

    @GetMapping("/join")
    public String login() {
        return "join";
    }
}
