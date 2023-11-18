package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;
import com.ywxx.cineEase.service.IMovieService;
import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements IMovieService {
    @Resource
    private MovieRepository movieRepository;

    @Override
    public Result getMovieById(Long id) {
        return null;
    }
}
