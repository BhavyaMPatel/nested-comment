package com.example.nestedcomment.Entity;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"Comment\"")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_by")
    private User commentBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_on")
    private Comment commentOn;

    @Column(name = "comment", length = Integer.MAX_VALUE)
    private String comment;

    @OneToMany
    @JoinColumn(name = "comment_on")
    private Set<Comment> comments = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(User commentBy) {
        this.commentBy = commentBy;
    }

    public Comment getCommentOn() {
        return commentOn;
    }

    public void setCommentOn(Comment commentOn) {
        this.commentOn = commentOn;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}