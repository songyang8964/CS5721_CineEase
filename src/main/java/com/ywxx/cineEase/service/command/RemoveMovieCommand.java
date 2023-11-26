package com.ywxx.cineEase.service.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.ywxx.cineEase.repository.MovieRepository;

public class RemoveMovieCommand implements MovieCommand {

    @Autowired
    private MovieRepository movieRepository;

    public RemoveMovieCommand(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void execute(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
