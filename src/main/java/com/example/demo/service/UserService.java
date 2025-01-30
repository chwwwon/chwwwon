package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.request.SaveUserRequestDto;
import com.example.demo.dto.request.UpdateUserRequestDto;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(SaveUserRequestDto saveUserRequestDto) {
        User user = userRepository.save(new User(saveUserRequestDto.getUsername(), saveUserRequestDto.getNickname(), saveUserRequestDto.getAge()));
        return user;
    }

    @Transactional
    public List<User> getUserList(){
        return userRepository.findAll();
    }

    @Transactional
    public User getUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        return user;
    }

    @Transactional
    public void updateUser(Long userId, UpdateUserRequestDto updateUserRequestDto){
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.updateUser(updateUserRequestDto.getUsername(), updateUserRequestDto.getNickname(), updateUserRequestDto.getAge());
    }

    @Transactional
    public void deleteUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        userRepository.delete(user);
    }
}
