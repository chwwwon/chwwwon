package com.example.demo.controller;

import com.example.demo.domain.Like;
import com.example.demo.dto.response.SaveLikeResponseDto;
import com.example.demo.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class LikeController {
    private LikeService likeService;

    public LikeController(LikeService likeService){
        this.likeService = likeService;
    }

    @PostMapping("/like")
    public Like save(@RequestBody SaveLikeResponseDto saveLikeResponseDto){
        return likeService.save(saveLikeResponseDto);
    }

    @DeleteMapping("/like")
    public void deleteLike(Long postId){
        likeService.deleteLike(postId);
    }
}

