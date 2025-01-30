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

    @PostMapping("/{postId}/like")
    public Like save(@RequestBody SaveLikeResponseDto saveLikeResponseDto,@PathVariable("postId") Long postId){
        return likeService.save(saveLikeResponseDto);
    }

    @DeleteMapping("/{postId}/like")
    public void deleteLike(@PathVariable("postId") Long postId){
        likeService.deleteLike(postId);
    }
}

