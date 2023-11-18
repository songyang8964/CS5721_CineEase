package com.ywxx.cineEase.repository;

import com.ywxx.cineEase.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByMovieId(Long movieId);

    List<Comment> findAllByUserId(Long userId);
}
