package com.example.test.service;

import com.example.test.entity.UserVO;
import com.example.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void joinUser(UserVO vo){
        userRepository.save(vo);
    }
}
