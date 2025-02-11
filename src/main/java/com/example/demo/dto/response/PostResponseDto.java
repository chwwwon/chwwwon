package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private final Long postId;
    private final String title;
    private final String content;
    private final Long userId;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.userId = post.getUser().getId();
    }
}
