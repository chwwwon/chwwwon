package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SaveUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User save(@RequestBody SaveUserRequestDto saveUserRequestDto) {
        return userService.save(saveUserRequestDto);
    }

    @PatchMapping("/{userId}")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        userService.updateUser(userId, updateUserRequestDto);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<User> getUsersList(){
        return userService.getUserList();
    }


    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable("userId") Long userId) {
        return userService.getUserByUserId(userId);
    }
}