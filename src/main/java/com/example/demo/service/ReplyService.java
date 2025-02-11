package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.domain.Reply;
import com.example.demo.domain.User;
import com.example.demo.dto.request.SaveReplyRequestDto;
import com.example.demo.dto.request.UpdateReplyRequestDto;
import com.example.demo.exception.CommonException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.ReplyRepository;
import com.example.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ReplyService(ReplyRepository replyRepository, UserRepository userRepository, PostRepository postRepository) {
        this.replyRepository = replyRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Transactional
    public Reply save(SaveReplyRequestDto saveReplyRequestDto){
        User user = userRepository.findById(saveReplyRequestDto.getUserId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
        Post post = postRepository.findById(saveReplyRequestDto.getPostId())
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_POST));
        return replyRepository.save(new Reply(saveReplyRequestDto.getContent()));
    }

    @Transactional
    public void updateReply(Long replyId, UpdateReplyRequestDto updateReplyRequestDto){
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_REPLY));
        reply.updateReply(updateReplyRequestDto.getContent());
    }

    @Transactional
    public void deleteReply(Long replyId){
        Reply reply = replyRepository.findById(replyId).orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_REPLY));
        replyRepository.delete(reply);
    }


}
