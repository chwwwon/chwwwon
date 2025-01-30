package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SaveUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.dto.response.UserListResponseDto;
import com.example.demo.dto.response.UserResponseDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final List<User> users = new ArrayList<>();

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody SaveUserRequestDto saveUserRequestDto) {
        return userService.save(saveUserRequestDto);
    }

    @GetMapping("/list")
    public UserListResponseDto getUsersList(){
        return new UserListResponseDto(userService.getUserList());
    }

    @GetMapping("/{userId}")
    public UserResponseDto getUser(@PathVariable("userId") Long userId) {
        return new UserResponseDto(userService.getUser(userId));
    }

    @PatchMapping("/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        userService.updateUser(userId, updateUserRequestDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

}