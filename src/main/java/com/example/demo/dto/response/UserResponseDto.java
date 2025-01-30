package com.example.demo.dto.response;

import com.example.demo.domain.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponseDto {
    private User user;

    public UserResponseDto(User user){
        this.user = user;
    }

}
