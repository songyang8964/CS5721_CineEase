package com.ywxx.cineEase.controller;

import com.ywxx.cineEase.service.BookingService;
import com.ywxx.cineEase.utils.type.PayMethodType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{ticketId}")
    public void processPayment(@PathVariable("ticketId") Long ticketId, @RequestParam Long userId, @RequestParam PayMethodType payMethod) {
        bookingService.booking(ticketId, userId, payMethod);
    }

    @GetMapping("/cancel/{orderInfoId}")
    public String cancelPayment(@PathVariable("orderInfoId") Long orderInfoId) {
        return bookingService.cancel(orderInfoId);
    }
}
