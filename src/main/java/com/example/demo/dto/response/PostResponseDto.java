package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostResponseDto {
    private Long postId;
    private String title;
    private String content;

    public PostResponseDto(Long postId, String title, String content ) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }

    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
