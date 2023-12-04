package com.ywxx.cineEase.service.command;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

public class UpdateMovieCommand implements MovieCommand {

    private final Movie updatedMovie;
    private Movie originalMovie;
    private final MovieRepository movieRepository;
    private boolean isExecuted = false;

    public UpdateMovieCommand(Movie updatedMovie, MovieRepository movieRepository) {
        this.updatedMovie = updatedMovie;
        this.movieRepository = movieRepository;
    }

    @Override
    public void execute(Long movieId) {
        originalMovie = movieRepository.findByMovieId(movieId);
        if (originalMovie != null) {
            originalMovie.setMovieName(updatedMovie.getMovieName());
            originalMovie.setSummary(updatedMovie.getSummary());
            originalMovie.setPrice(updatedMovie.getPrice());
            originalMovie.setActors(updatedMovie.getActors());
            originalMovie.setLanguage(updatedMovie.getLanguage());
            originalMovie.setDurationMins(updatedMovie.getDurationMins());
            originalMovie.setGenre(updatedMovie.getGenre());
            movieRepository.save(originalMovie);
            isExecuted = true;
        }
    }

    @Override
    public void undo() {
        if (isExecuted && originalMovie != null) {
            movieRepository.save(originalMovie);
            originalMovie = null;
            isExecuted = false;
        }
    }
}
