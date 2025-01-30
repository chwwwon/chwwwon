package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SavePostRequestDto {
    private final Long userId;
    private final String title;
    private final String content;

    @JsonCreator
    public SavePostRequestDto(
            @JsonProperty("userId") Long userId,
            @JsonProperty("title") String title,
            @JsonProperty("nickname") String content
    ) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
