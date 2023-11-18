package com.ywxx.cineEase.controller;


import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.entity.Screen;
import com.ywxx.cineEase.entity.Seat;
import com.ywxx.cineEase.entity.Ticket;
import com.ywxx.cineEase.repository.ScreenRepository;
import com.ywxx.cineEase.repository.SeatRepository;
import com.ywxx.cineEase.repository.TicketRepository;
import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;
import com.ywxx.cineEase.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/book")
public class BookingController {

    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreenRepository screenRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private TicketService ticketService;
    @GetMapping("/{movieName}")
    public Movie selectMovie(@PathVariable("movieName") String movieName)
    {
        Movie movie = movieService.getMovieByName(movieName);
        return movie;
    }

    @GetMapping("/{movieName}/screen")
    public List<Screen> selectScreen(@PathVariable("movieName") String movieName)
    {
        List<Screen> result = new ArrayList<>();
        result = screenRepository.findByMovieId(movieService.getMovieByName(movieName).getMovieId());
        for(Screen screen:result)
        {
            if(!screen.isAvailableFlag())
            {
                result.remove(screen);
            }
        }
        return result;
    }

    @GetMapping("/{movieName}/screen/{screenId}")
    public List<Seat> selectSeat(@PathVariable("movieName") String movieName,@PathVariable("screenId") long screenId)
    {
        List<Seat> result = seatRepository.findByScreenId(screenId);
        for(Seat seat:result)
        {
            if(!seat.isAvailable())
            {
                result.remove(seat);
            }
        }
        return result;
    }

    @GetMapping("/{movieName}/seat/{seatId}")
    public Result bookSeat(@PathVariable("movieName") String movieName,@PathVariable("seatId") long seatId)
    {
        Seat seat = seatRepository.findById(seatId).get();
        if(seat.isAvailable()) {
            Ticket ticket = new Ticket();
            Random random = new Random();
            long randomID = random.nextLong(10000000000L);
            ticket.setSeatId(seatId);
            ticket.setTicketStatus("0");
            ticket.setTime(seat.getTime());
            //todo ticket.setCustomer();
            ticket.setPaymentStatus("0");
            ticket.setScreenNum(screenRepository.findByScreenId(seat.getScreenId()).getScreenNum());
            ticket.setScreenId(seat.getScreenId());
            ticket.setTicketId(randomID);
            return Result.ok(ticket);
        }
        return Result.fail("seat has been taken");
    }

    @DeleteMapping("/{ticketId}")
    public Result deleteTicket(@PathVariable("ticketId") long ticketId)
    {
       return ticketService.deleteTicketById(ticketId);

    }

}
