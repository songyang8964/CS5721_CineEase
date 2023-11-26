package com.ywxx.cineEase.service;

import com.ywxx.cineEase.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;
import com.ywxx.cineEase.service.command.MovieCommand;
import com.ywxx.cineEase.service.command.MovieCommandManager;
import com.ywxx.cineEase.service.command.RemoveMovieCommand;
import com.ywxx.cineEase.service.command.UpdateMovieCommand;

@Service
public class MovieService {

     @Autowired
     private MovieRepository movieRepository;
     private MovieCommandManager commandManager; 

     public MovieService(MovieRepository movieRepository, MovieCommandManager commandManager) {
          this.movieRepository = movieRepository;
          this.commandManager = commandManager;
      }

     public List<Movie> getAllMovies() {
          return (List<Movie>) movieRepository.findAll();
     }

     public Result getMovieById(long movieId) {
          return Result.ok(movieRepository.findByMovieId(movieId));
     }

     public Movie getMovieByName(String movieName) {
          return movieRepository.findByMovieName(movieName);
     }

     public void addMovie(Movie movie) {
          movieRepository.save(movie);
     }

     public Result updateMovie(Long movieId, Movie updatedMovie) {
          if (movieRepository.existsById(movieId)) {
               MovieCommand updateCommand = new UpdateMovieCommand(updatedMovie, movieRepository);
               commandManager.executeCommand(updateCommand, movieId);
               return Result.ok();
          }
          return Result.fail("movie does not exist");
     }

     public Result deleteMovieById(Long movieId) {
          if (movieRepository.existsById(movieId)) {
               MovieCommand deleteComand = new RemoveMovieCommand(movieRepository);
               commandManager.executeCommand(deleteComand, movieId);
               return Result.ok();
          }
          return Result.fail("movie does not exist");
     }


}
