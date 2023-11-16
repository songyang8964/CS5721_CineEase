package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.entity.Comment;
import com.ywxx.cineEase.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/movieId/{movieId}")
    public List<Comment> findAllByMovieId(@PathVariable("movieId") Long movieId) {
        return commentService.findAllByMovieId(movieId);
    }

    @GetMapping("/userId/{userId}")
    public List<Comment> findAllByUserId(@PathVariable("userId") Long userId) {
        return commentService.findAllByUserId(userId);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PutMapping
    public Comment updateComment(@RequestBody  Comment comment) {
        return commentService.updateComment(comment);
    }

    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable("id") Long id) {
        commentService.deleteCommentById(id);
    }

    @GetMapping("/{id}")
    public Optional<Comment> findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }
}
