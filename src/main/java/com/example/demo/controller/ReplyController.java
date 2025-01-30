package com.example.demo.controller;

import com.example.demo.domain.Reply;
import com.example.demo.dto.request.SaveReplyRequestDto;
import com.example.demo.dto.request.UpdateReplyRequestDto;
import com.example.demo.service.ReplyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class ReplyController {
    private ReplyService replyService;

    public ReplyController(ReplyService replyService){
        this.replyService = replyService;
    }

    @PostMapping("/{postId}/reply")
    public Reply save(@RequestBody SaveReplyRequestDto saveReplyRequestDto, @PathVariable("postId") Long postID){
        return replyService.save(saveReplyRequestDto);
    }

    @PatchMapping("/{postId}/reply/{replyId}")
    public void updateReply(@PathVariable("postId") Long postId, @PathVariable("replyId") Long replyId, @RequestBody UpdateReplyRequestDto updateReplyRequestDto){
        replyService.updateReply(replyId, updateReplyRequestDto);
    }

    @DeleteMapping("/{postId}/reply/{replyId}")
    public void deleteReply(@PathVariable("postId") Long postId, @PathVariable("replyId") Long replyId){
        replyService.deleteReply(replyId);
    }

}
