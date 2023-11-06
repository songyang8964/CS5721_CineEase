package com.ywxx.cineEase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ywxx.cineEase.entity.Movie;

// import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    // List<Movie> findAll();
    // Movie findById(int id);
}

