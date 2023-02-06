package com.example.githublogin.controller.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDto {
    int id;
    String socialId;
    String name;
    String email;

    public UserDto(String socialId, String name, String email) {
        this.socialId = socialId;
        this.name = name;
        this.email = email;
    }
}
