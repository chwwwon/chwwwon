package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    private Long userId;

    @ManyToMany(mappedBy = "likes")
    private List<User> user = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    private Post post;

    protected Like(){}

    public Like(Long userId, Post post) {
        this.userId = userId;
        this.post = post;
    }

}
