package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;
import com.ywxx.cineEase.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private TicketService ticketService;

    @GetMapping("/ticket/{customerId}")
    public String queryMovieById(@PathVariable("customerId") Long customerId) {
        return ticketService.findAllTicketsByCustomerId(customerId).toString();
    }
}
