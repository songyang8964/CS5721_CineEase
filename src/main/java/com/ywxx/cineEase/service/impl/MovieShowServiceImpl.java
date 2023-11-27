package com.ywxx.cineEase.service.impl;

import com.ywxx.cineEase.service.BookingService;
import com.ywxx.cineEase.utils.type.PayMethodType;

public class MovieShowServiceImpl implements BookingService {
    private String movieName;

    public MovieShowServiceImpl(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public void booking(Long ticketId, Long userId, PayMethodType payMethod) {

    }

    @Override
    public String cancel(Long orderInfoId) {
        return null;
    }



    public void show(){
        System.out.println("Booking a show for: " + movieName);
    }

}
