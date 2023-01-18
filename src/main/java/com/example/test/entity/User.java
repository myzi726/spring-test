package com.example.test.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {
    @Id
    @Column(name="userId")
    private String userId;

    @Column (name = "password",nullable = false)
    private String password;

    @Column (name = "userName", nullable = false)
    private String userName;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
