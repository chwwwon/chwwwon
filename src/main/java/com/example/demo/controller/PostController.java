package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.SavePostRequestDto;
import com.example.demo.dto.request.UpdatePostRequestDto;
import com.example.demo.dto.response.PostListResponseDto;
import com.example.demo.dto.response.PostResponseDto;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post save(@RequestBody SavePostRequestDto savePostRequestDto){
        return postService.save(savePostRequestDto);
    }

    @PatchMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Long postId, @RequestBody UpdatePostRequestDto updatePostRequestDto){
        postService.updatePost(postId, updatePostRequestDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable("postId") Long postId){
        return new PostResponseDto(postService.getPost(postId));
    }

    @GetMapping("/list")
    public PostListResponseDto getPostList(){
        return new PostListResponseDto(postService.getPostList());
    }

    @GetMapping("/users/{userId}")
    public PostListResponseDto getPostListByUserId(@PathVariable("userId") Long userId){
        return new PostListResponseDto(postService.getPostListByUserId(userId));
    }

}
