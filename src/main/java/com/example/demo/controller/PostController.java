package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.SavePostRequestDto;
import com.example.demo.dto.request.UpdatePostRequestDto;
import com.example.demo.dto.response.PostResponseDto;
import com.example.demo.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void save(@RequestBody SavePostRequestDto savePostRequestDto){
        postService.save(savePostRequestDto);
    }

    @PatchMapping
    public void updatePost(@RequestBody UpdatePostRequestDto updatePostRequestDto){
        postService.updatePost(updatePostRequestDto);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

    @GetMapping
    public List<PostResponseDto> getPostList(){
        List<PostResponseDto> postList = postService.getPostList();
        return postList;
    }

    @GetMapping("/{postId}")
    public Post getPostByPostId(@PathVariable("postId") Long postId){
        return postService.getPostByPostId(postId);
        //return new PostResponseDto(postService.getPostByPostId(postId));
    }

    @GetMapping("/users/{userId}")
    public List<Post> getPostListByUserId(@PathVariable("userId") Long userId){
        return postService.getPostListByUserId(userId);
    }

}
