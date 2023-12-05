package com.ywxx.cineEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ywxx.cineEase.entity.Ticket;
import com.ywxx.cineEase.repository.TicketRepository;
import com.ywxx.cineEase.utils.Result;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    public List<Ticket> findAllTicketsByCustomerId(Long customerId) {
        return ticketRepository.findByCustomer_CustomerId(customerId);
    }

    public Result deleteTicketById(Long ticketId) {
        if (ticketRepository.existsById(ticketId)) {
               ticketRepository.deleteById(ticketId);
               return Result.ok();
          }
        return Result.fail("ticket does not exist");
    }
}
