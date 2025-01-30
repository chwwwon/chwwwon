package com.example.demo.service;

import com.example.demo.domain.Like;
import com.example.demo.dto.response.SaveLikeResponseDto;
import com.example.demo.repository.LikeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository){
        this.likeRepository = likeRepository;
    }

    @Transactional
    public Like save(SaveLikeResponseDto saveLikeResponseDto){
        return likeRepository.save(new Like(saveLikeResponseDto.getUserId(), saveLikeResponseDto.getPostId()));
    }

    @Transactional
    public void deleteLike(Long likeId){
        Like like = likeRepository.findById(likeId).orElseThrow(IllegalArgumentException::new);
        likeRepository.delete(like);
    }
}
