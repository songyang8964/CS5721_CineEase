package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.entity.Comment;
import com.ywxx.cineEase.repository.CommentRepository;
import com.ywxx.cineEase.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllByMovieId(Long movieId) {
        return commentRepository.findAllByMovieId(movieId);
    }

    @Override
    public List<Comment> findAllByUserId(Long userId) {
        return commentRepository.findAllByUserId(userId);
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }
}
