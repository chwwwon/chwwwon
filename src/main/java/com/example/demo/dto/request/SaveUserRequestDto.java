package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveUserRequestDto {
    private final String username;
    private final String nickname;
    private final int age;

    @JsonCreator
    public SaveUserRequestDto(
            @JsonProperty("username") String username,  // JSON의 "username" 필드를 매핑
            @JsonProperty("nickname") String nickname, // JSON의 "nickname" 필드를 매핑
            @JsonProperty("age") int age
    ) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }
}
