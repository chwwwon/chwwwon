package com.example.demo.dto.request;

import lombok.Getter;

@Getter
public class UpdatePostRequestDto {
    private Long postId;
    private String title;
    private String content;
}
