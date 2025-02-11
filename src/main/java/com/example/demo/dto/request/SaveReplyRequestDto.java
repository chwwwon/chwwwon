package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SaveReplyRequestDto {
    private final String content;
    private final Long userId;
    private final Long postId;

    @JsonCreator
    public SaveReplyRequestDto(@JsonProperty("content") String content, Long userId, Long postId) {

        this.content = content;
        this.userId = userId;
        this.postId = postId;
    }
}
