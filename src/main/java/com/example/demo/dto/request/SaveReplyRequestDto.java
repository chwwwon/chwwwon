package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveReplyRequestDto {
    private final String reply;

    @JsonCreator
    public SaveReplyRequestDto(@JsonProperty("reply") String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }
}
