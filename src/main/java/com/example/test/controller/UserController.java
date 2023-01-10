package com.example.test.controller;

import com.example.test.entity.UserVO;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/joinUs.do", method= RequestMethod.POST)
    public String joinUs(UserVO vo) {

        userService.joinUser(vo);
        return "index";
    }


}
