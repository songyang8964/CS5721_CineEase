package com.ywxx.cineEase.controller;


import com.ywxx.cineEase.entity.*;
import com.ywxx.cineEase.repository.CustomerRepository;
import com.ywxx.cineEase.repository.ScreenRepository;
import com.ywxx.cineEase.repository.SeatRepository;
import com.ywxx.cineEase.repository.TicketRepository;
import com.ywxx.cineEase.service.MovieService;
import com.ywxx.cineEase.service.TicketService;
import com.ywxx.cineEase.service.impl.BookingServiceImpl;
import com.ywxx.cineEase.utils.Result;
import com.ywxx.cineEase.utils.type.PayMethodType;
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
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    BookingServiceImpl bookingService;
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

    @GetMapping("/{movieName}/seat/{seatId}/{userId}")
    public Result bookSeat(@PathVariable("movieName") String movieName,@PathVariable("seatId") long seatId,@PathVariable("userId") long userId)
    {
        Seat seat = seatRepository.findById(seatId).get();
        if(seat.isAvailable()) {
            Ticket ticket = new Ticket();
            Random random = new Random();
            long randomID = random.nextLong(10000000000L);
            ticket.setSeatId(seatId);
            ticket.setTicketStatus("0");
            ticket.setTime(seat.getTime());
            ticket.setCustomer(customerRepository.findById(userId).get());
            ticket.setPaymentStatus("0");
            ticket.setScreenNum(screenRepository.findByScreenId(seat.getScreenId()).getScreenNum());
            ticket.setScreenId(seat.getScreenId());
            ticket.setTicketId(randomID);
            bookingService.booking(randomID,userId, PayMethodType.CARD);
            ticketRepository.save(ticket);
            return Result.ok(ticket);
        }
        return Result.fail("seat has been taken");
    }

    @DeleteMapping("/{ticketId}/{orderId}")
    public String deleteTicket(@PathVariable("ticketId") long ticketId,@PathVariable("orderId") long orderId)
    {
        ticketService.deleteTicketById(ticketId);
        return bookingService.cancel(orderId);


    }

}
