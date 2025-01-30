package com.example.demo.service;

import com.example.demo.domain.Reply;
import com.example.demo.dto.request.SaveReplyRequestDto;
import com.example.demo.dto.request.UpdateReplyRequestDto;
import com.example.demo.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
    private final ReplyRepository replyRepository;

    public ReplyService(ReplyRepository replyRepository){
        this.replyRepository = replyRepository;
    }

    @Transactional
    public Reply save(SaveReplyRequestDto saveReplyRequestDto){
        return replyRepository.save(new Reply(saveReplyRequestDto.getReply()));
    }

    @Transactional
    public void updateReply(Long replyId, UpdateReplyRequestDto updateReplyRequestDto){
        Reply reply = replyRepository.findById(replyId).orElseThrow(IllegalArgumentException::new);
        reply.updateReply(updateReplyRequestDto.getReply());
    }

    @Transactional
    public void deleteReply(Long replyId){
        Reply reply = replyRepository.findById(replyId).orElseThrow(IllegalArgumentException::new);
        replyRepository.delete(reply);
    }


}
