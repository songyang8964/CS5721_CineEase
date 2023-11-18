package com.ywxx.cineEase.service;

import com.ywxx.cineEase.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findAllByMovieId(Long movieId);

    List<Comment> findAllByUserId(Long userId);

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    void deleteCommentById(Long id);

    Optional<Comment> findById(Long id);

}
