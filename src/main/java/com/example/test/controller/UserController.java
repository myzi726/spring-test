package com.example.test.controller;

import com.example.test.repository.UserRequestDto;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("entity")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("signup")
    public String createForm() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserRequestDto userDto) {
        String result = userService.signup(userDto);
        return result;
    }
}