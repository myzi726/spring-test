package com.example.test.controller;

import com.example.test.repository.UserRequestDto;
import com.example.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private UserService userService;

    @GetMapping("/login")
    public String loginForm(){
        return "/login";
    }
}
