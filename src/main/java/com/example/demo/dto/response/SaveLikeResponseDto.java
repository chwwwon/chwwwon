package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SaveLikeResponseDto {
    private Long likeId;
    private Long userId;
    private Post post;

    protected SaveLikeResponseDto() {}

    public SaveLikeResponseDto( Long userId, Post post) {
        this.userId = userId;
        this.post = post;
    }
}
