package com.example.test.repository;

import com.example.test.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public final class UserRequestDto {
    private String userId;
    private String password;
    private String userName;

    public User toEntity() {
        return new User(userId, password, userName);
    }
}