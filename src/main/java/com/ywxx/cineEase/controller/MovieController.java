package com.ywxx.cineEase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/save")
    public void saveMovie() {
        Movie m = new Movie("Godfather1");
        movieRepository.save(m);
    }

    @GetMapping("/movies")
    public String listMovies() {
        return movieRepository.findAll().toString();
    }


}
