package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "replies")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    private String reply;

    protected Reply(){}

    public Reply(String reply){
        this.reply = reply;
    }

    public void updateReply(String reply){
        this.reply = reply;
    }
}
