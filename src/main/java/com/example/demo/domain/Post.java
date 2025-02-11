package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    /*@OneToMany(mappedBy = "post")
    private List<Reply> replies;

    @OneToMany(mappedBy = "post")
    private List<Like> likes;*/

    protected Post() {}

    public Post(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updatePost(String title, String content){
        this.title = title;
        this.content = content;
    }


}
