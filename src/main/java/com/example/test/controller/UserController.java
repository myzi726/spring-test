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
@RequestMapping("entity")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("signup")
    public String signup() {
        return "signup";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody UserRequestDto userDTO) {
        log.info("userId = {}, password = {}, userName = {}",
                userDTO.getUserId(), userDTO.getPassword(), userDTO.getUserName());

        if(userService.signup(userDTO).equals("Success")) {
            return new ResponseEntity((HttpStatus.CREATED));
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
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