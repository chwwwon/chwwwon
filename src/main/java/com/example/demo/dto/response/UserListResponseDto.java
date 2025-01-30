package com.example.demo.dto.response;

import com.example.demo.domain.User;
import lombok.Getter;

import java.util.List;

@Getter
public class UserListResponseDto {
    private List<User> users;

    public UserListResponseDto(List<User> users){
        this.users = users;
    }

}
