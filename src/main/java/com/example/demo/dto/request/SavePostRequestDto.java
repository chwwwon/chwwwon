package com.example.demo.dto.request;

import com.example.demo.domain.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SavePostRequestDto {
    private User user;
    private final String title;
    private final String content;

    @JsonCreator
    public SavePostRequestDto(
            @JsonProperty("title") String title,
            @JsonProperty("nickname") String content
    ) {
        this.title = title;
        this.content = content;
    }
}
