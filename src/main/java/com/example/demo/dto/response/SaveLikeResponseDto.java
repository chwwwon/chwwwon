package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
public class SaveLikeResponseDto {
    private Long likeId;
    private Long userId;
    private Long postId;

    protected SaveLikeResponseDto() {}

    public SaveLikeResponseDto(Long userId, Long postId) {
        this.userId = userId;
        this.postId = postId;
    }
}
