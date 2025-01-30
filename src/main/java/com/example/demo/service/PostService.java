package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.dto.request.SavePostRequestDto;
import com.example.demo.dto.request.UpdatePostRequestDto;
import com.example.demo.dto.response.PostResponseDto;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Post save(SavePostRequestDto savePostRequestDto) {
        Post post = postRepository.save(new Post(savePostRequestDto.getUserId(), savePostRequestDto.getTitle(), savePostRequestDto.getContent()));
        return post;
    }

    @Transactional
    public void updatePost(Long postId, UpdatePostRequestDto updatePostRequestDto){
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        post.updatePost(updatePostRequestDto.getTitle(), updatePostRequestDto.getContent());
    }

    @Transactional
    public void deletePost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
        postRepository.delete(post);
    }

    @Transactional
    public Post getPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Page<Post> getPostList(int page, int size){
        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by("postId"));
        return postRepository.findAll(pageable);
    }

    @Transactional
    public List<Post> getPostListByUserId(Long userId){
        return postRepository.findByUserId(userId);
    }

}
