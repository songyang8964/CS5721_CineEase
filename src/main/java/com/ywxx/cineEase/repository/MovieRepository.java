package com.ywxx.cineEase.repository;

import com.ywxx.cineEase.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Custom query methods (if needed) go here
    Movie findByMovieName(String movieName);

    Movie findByMovieId(Long movieId);
}