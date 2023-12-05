package com.ywxx.cineEase.service.command;

import org.springframework.beans.factory.annotation.Autowired;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

public class RemoveMovieCommand implements MovieCommand {

    @Autowired
    private Movie deletedMovie;
    private MovieRepository movieRepository;
    private boolean isExecuted = false;

    public RemoveMovieCommand(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void execute(Long movieId) {
        deletedMovie = movieRepository.findById(movieId).orElse(null);
        if (deletedMovie != null) {
            movieRepository.deleteById(movieId);
            isExecuted = true;
        }
    }

    @Override
    public void undo() {
        if (isExecuted && deletedMovie != null) {
            movieRepository.save(deletedMovie);
            deletedMovie = null;
            isExecuted = false;
        }
    }
}
