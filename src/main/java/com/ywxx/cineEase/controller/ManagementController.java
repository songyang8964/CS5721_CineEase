package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;

@RestController
@RequestMapping("/admin")
public class ManagementController {
    @Resource
    private MovieService movieService;
    @Resource
    private TicketService ticketService;

    @PostMapping("/movie/save")
    public Result saveMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return Result.ok();
    }

    @DeleteMapping("/movie/delete/{id}")
    public Result deleteMovieById(@PathVariable("id") Long id) {
        return movieService.deleteMovieById(id);
    }

    @PutMapping("/movie/update/{id}")
    public Result updateMovie(@PathVariable("id") Long movieId, @RequestBody Movie movie) {
        return movieService.updateMovie(movieId, movie);
    }

    @GetMapping("/ticket/all")
    public String listTickets() {
        return ticketService.getAllTickets().toString();
    }

}
