package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Resource
    private MovieService movieService;

    @GetMapping("/{id}")
    public Result queryMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/all")
    public String listMovies() {
        return movieService.getAllMovies().toString();
    }

}
