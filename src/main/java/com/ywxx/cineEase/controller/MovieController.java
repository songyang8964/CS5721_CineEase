package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.service.IMovieService;
import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Resource
    private IMovieService movieService;

    @GetMapping("/{id}")
    public Result queryMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }


}
