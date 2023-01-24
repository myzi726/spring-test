package com.example.test.controller;

import com.example.test.repository.UserRequestDto;
import com.example.test.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping("entity")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("signup")
    public String createForm() {
        return "signup";
    }

    @GetMapping("login")
    public String loginForm() {
        return "login";
    }


    @PostMapping("/signup")
    public String signup(UserRequestDto userDto) {
        String result = userService.signup(userDto);
        return result;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserRequestDto userDto) {
        log.info("userId = {}, password = {}", userDto.getUserId(), userDto.getPassword());

        if(userService.login(userDto.getUserId(), userDto.getPassword()).equals("Success")) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}