package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;
import com.ywxx.cineEase.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Resource
    private MovieService movieService;

    @PostMapping("/save")
    public Result saveMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return Result.ok();

    }

    @GetMapping("/{id}")
    public Result queryMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/delete/{id}")
        public Result deleteMovieById(@PathVariable("id") Long id) {
        return movieService.deleteMovieById(id);
    }

    @GetMapping("/all")
    public String listMovies() {
        return movieService.getAllMovies().toString();
    }

    @PutMapping("/update/{id}")
    public Result updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
        // write to database
        return movieService.updateMovie(movieId, movie);
    }

}
