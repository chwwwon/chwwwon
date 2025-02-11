package com.example.demo.service;

import com.example.demo.domain.Like;
import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.response.SaveLikeResponseDto;
import com.example.demo.exception.CommonException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Like save(SaveLikeResponseDto saveLikeResponseDto){
        User user = userRepository.findById(saveLikeResponseDto.getUserId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
        Post post = postRepository.findById(saveLikeResponseDto.getPostId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_POST));
        return likeRepository.save(new Like(user, post));
    }

    @Transactional
    public void deleteLike(Long likeId){
        Like like = likeRepository.findById(likeId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_LIKE));
        likeRepository.delete(like);
    }
}
