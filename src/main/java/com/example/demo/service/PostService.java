package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.User;
import com.example.demo.dto.request.SavePostRequestDto;
import com.example.demo.dto.request.UpdatePostRequestDto;
import com.example.demo.dto.response.PostResponseDto;
import com.example.demo.exception.CommonException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

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
        User user = userRepository.findById(savePostRequestDto.getUserId())
                .orElseThrow(() -> new CommonException("찾을 수 없음 회원 아이디"));

        Post post = postRepository.save(new Post(user, savePostRequestDto.getTitle(), savePostRequestDto.getContent()));
        return post;
    }

    @Transactional  //JPA 지연로딩 때문에 안 될 가능성 체크
    public void updatePost(UpdatePostRequestDto updatePostRequestDto){
        Post post = postRepository.findById(updatePostRequestDto.getPostId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_POST));
        post.updatePost(updatePostRequestDto.getTitle(), updatePostRequestDto.getContent());
    }

    @Transactional
    public void deletePost(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_POST));
        postRepository.delete(post);
    }

    @Transactional
    public List<PostResponseDto> getPostList(){
        List<Post> postlist = postRepository.findAll();
        return postlist.stream()
                .map(PostResponseDto::new)
                .toList();
    }

    @Transactional
    public Post getPostByPostId(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_POST));
    }
   /* @Transactional
    public Page<Post> getPostList(int page, int size){
        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by("postId"));
        return postRepository.findAll(pageable);
    }*/

    @Transactional
    public List<Post> getPostListByUserId(Long userId){
        return postRepository.findByUserId(userId);
    }

}
