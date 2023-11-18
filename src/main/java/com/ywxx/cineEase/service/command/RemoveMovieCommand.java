package com.ywxx.cineEase.service.command;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

public class RemoveMovieCommand implements MovieCommand {

    private final Movie movieToRemove;
    private final MovieRepository movieRepository;

    public RemoveMovieCommand(Movie movieToRemove,MovieRepository movieRepository) {
        this.movieToRemove = movieToRemove;
        this.movieRepository = movieRepository;
    }

    @Override
    public void execute() {
        // TODO Perform the remove operation
        System.out.println("removed a movie");
    }

}
