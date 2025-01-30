package com.example.demo.dto.request;

import lombok.Getter;

@Getter
public class UpdateUserRequestDto {
    private String username;
    private String nickname;
    private int age;
}
