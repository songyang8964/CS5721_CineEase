package com.ywxx.cineEase.service.command;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

public class UpdateMovieCommand implements MovieCommand {

    private Movie movieToUpdate;
    private Movie updatedMovie;
    private MovieRepository movieRepository;

    public UpdateMovieCommand(Movie movieToUpdate, Movie updatedMovie, MovieRepository movieRepository) {
        this.movieToUpdate = movieToUpdate;
        this.updatedMovie = updatedMovie;
        this.movieRepository = movieRepository;
    }



    @Override
    public void execute() {
        // TODO Perform the update operation
        System.out.println("updated a movie");
    }

}
