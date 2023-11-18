package com.ywxx.cineEase.service;

import com.ywxx.cineEase.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.repository.MovieRepository;

@Service
public class MovieService {

     @Autowired
     private MovieRepository movieRepository;

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
               Movie existingMovie = movieRepository.findByMovieId(movieId);
               existingMovie.setMovieName(updatedMovie.getMovieName());
               existingMovie.setSummary(updatedMovie.getSummary());
               existingMovie.setPrice(updatedMovie.getPrice());
               existingMovie.setActors(updatedMovie.getActors());
               existingMovie.setLanguage(updatedMovie.getLanguage());
               existingMovie.setDurationMins(updatedMovie.getDurationMins());
               existingMovie.setGenre(updatedMovie.getGenre());
               return Result.ok(movieRepository.save(existingMovie));
          }
          return Result.fail("movie does not exist");
     }

     public Result deleteMovieById(Long movieId) {
          if (movieRepository.existsById(movieId)) {
               movieRepository.deleteById(movieId);
               return Result.ok();
          }
          return Result.fail("movie does not exist");
     }

}
