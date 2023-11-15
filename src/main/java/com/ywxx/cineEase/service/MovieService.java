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
         // return movieRepository.findByMovieId(movieId);
          return Result.ok(movieRepository.findByMovieId(movieId));
     }

     public Movie getMovieByName(String movieName) {
          return movieRepository.findByMovieName(movieName);
     }

     public void addMovie(Movie movie) {
          movieRepository.save(movie);
     }

     public Result updateMovie(Movie movie) {
          Long movieId = movie.getMovieId();
          if (movieRepository.findByMovieId(movieId) == null) {
               return Result.fail("movie does not exist");
          }
          updateMovie(movie);
            return Result.ok();
     }

//     public void deleteMovie(long movieId) {
//          movieRepository.deleteById(movieId);
//     }


}
