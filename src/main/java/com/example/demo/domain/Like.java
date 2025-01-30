package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long likeId;

    private Long userId;

    private Long postId;

    protected Like(){}

    public Like(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }

}
