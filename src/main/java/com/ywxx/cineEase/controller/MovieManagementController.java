package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.service.MovieService;

@RestController
@RequestMapping("/admin/movie") 
public class MovieManagementController {
    @Resource
    private MovieService movieService;
    
    @PostMapping("/save")
    public Result saveMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return Result.ok();
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteMovieById(@PathVariable("id") Long id) {
        return movieService.deleteMovieById(id);
    }
    
    @PutMapping("/update/{id}")
    public Result updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
        // write to database
        return movieService.updateMovie(movieId, movie);
    }

}
