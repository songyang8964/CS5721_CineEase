package com.ywxx.cineEase.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "rate")
    private Long rate;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "create_on")
    private Date createOn;
    @Column(name = "thumb_up")
    private Long thumbUp;
    @Column(name = "reply_id")
    private Long replyId;

    public Comment() {

    }

    public Comment(Long id, String content, Long userId, Long rate, Long movieId, Date createOn, Long thumbUp, Long replyId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.rate = rate;
        this.movieId = movieId;
        this.createOn = createOn;
        this.thumbUp = thumbUp;
        this.replyId = replyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Long getThumbUp() {
        return thumbUp;
    }

    public void setThumbUp(Long thumbUp) {
        this.thumbUp = thumbUp;
    }

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }
}
