package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.repository.UserRepository;
import com.example.test.repository.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public String login(String userId, String password) {
        Optional<User> user = userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}",
        user.get().getPassword(), password);

        if(user.get().getPassword().equals(password)) {
            return "Success";
        }
        return "Failed";
    }
}
