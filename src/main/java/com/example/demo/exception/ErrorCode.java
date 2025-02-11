package com.example.demo.exception;

import lombok.Getter;

@Getter
public class ErrorCode {
    public static final String NOT_FOUND_POST = "게시글이 존재하지 않음.";
    public static final String NOT_FOUND_USER = "회원이 존재하지 않음.";
    public static final String NOT_FOUND_REPLY = "댓글이 존재하지 않음.";
    public static final String NOT_FOUND_LIKE = "좋아요가 존재하지 않음";
}
