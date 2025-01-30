package com.example.demo.repository;

import com.example.demo.domain.Post;
import com.example.demo.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("select new com.example.demo.dto.response.PostResponseDto(p.postId, p.title, p.content) from Post p where p.userId = :userId")
//    Page<PostResponseDto> findAllByUserId(@Param("userId")Long userId, Pageable pageable);
    Page<Post> findAll(Pageable pageable);
    List<Post> findByUserId(@Param("userId") Long userId);
}