package com.ywxx.cineEase.service.command;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

public class UpdateMovieCommand implements MovieCommand {

    private Movie updatedMovie;
    private MovieRepository movieRepository;

    public UpdateMovieCommand(Movie updatedMovie, MovieRepository movieRepository) {
        this.updatedMovie = updatedMovie;
        this.movieRepository = movieRepository;
    }

    @Override
    public void execute(Long movieId) {
        Movie existingMovie = movieRepository.findByMovieId(movieId);
        existingMovie.setMovieName(updatedMovie.getMovieName());
        existingMovie.setSummary(updatedMovie.getSummary());
        existingMovie.setPrice(updatedMovie.getPrice());
        existingMovie.setActors(updatedMovie.getActors());
        existingMovie.setLanguage(updatedMovie.getLanguage());
        existingMovie.setDurationMins(updatedMovie.getDurationMins());
        existingMovie.setGenre(updatedMovie.getGenre());
        movieRepository.save(existingMovie);
    }

}
