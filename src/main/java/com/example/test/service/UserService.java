package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import com.example.test.repository.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@Builder
public class UserService {

    private final UserRepository userRepository;

    public String signup(UserRequestDto userDto) {
        try {
            User user = userDto.toEntity();
            System.out.println("user.toString() = " + user.toString());
            userRepository.save(userDto.toEntity());
            return "Success";
        } catch (Exception e) {
            return "Fail";
        }
    }
}
