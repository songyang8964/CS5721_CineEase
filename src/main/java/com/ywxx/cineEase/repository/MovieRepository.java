package com.ywxx.cineEase.repository;


import com.ywxx.cineEase.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    Movie findByMovieName(String movieName);
    Movie findByMovieId(Long movieId);
}
