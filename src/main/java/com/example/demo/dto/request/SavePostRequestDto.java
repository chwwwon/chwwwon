package com.example.demo.dto.request;

import com.example.demo.domain.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SavePostRequestDto {
    private final Long userId;
    private final String title;
    private final String content;

    @JsonCreator
    public SavePostRequestDto(
            @JsonProperty("user_id") Long userId,
            @JsonProperty("title") String title,
            @JsonProperty("nickname") String content
    ) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
