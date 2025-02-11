package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String username;

    private String nickname;

    private int age;

    /*@OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Reply> replies;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;*/

    protected User() {}

    public User(String username, String nickname, int age) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }

    public void updateUser(String username, String nickname, int age) {
        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }
}