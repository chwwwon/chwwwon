package com.example.demo.dto.response;

import com.example.demo.domain.Post;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class PostListResponseDto {
    private List<Post> posts;
    private int totalPages;
    private int page;
    private int size;

    public PostListResponseDto(List<Post> posts){
        this.posts = posts;
    }

    public PostListResponseDto(Page<Post> postPage){
        this.posts = postPage.getContent();
        this.totalPages = postPage.getTotalPages();
        this.page = postPage.getNumber();
        this.size = postPage.getSize();
    }
}
