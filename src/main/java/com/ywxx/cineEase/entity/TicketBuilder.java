package com.ywxx.cineEase.entity;

import java.sql.Timestamp;

public class TicketBuilder
{
    private Ticket ticket;
    public TicketBuilder()
    {
        ticket = new Ticket();
    }

    public TicketBuilder setSeatId(long seatId)
    {
        ticket.setSeatId(seatId);
        return this;
    }
    public TicketBuilder withTicketId(long ticketId) {
        ticket.setTicketId(ticketId);
        return this;
    }

    public TicketBuilder withCustomer(Customer customer)
    {
        ticket.setCustomer(customer);
        return this;
    }
    public TicketBuilder withScreenNum(long screenNum) {
        ticket.setScreenNum(screenNum);
        return this;
    }

    public TicketBuilder withScreenId(long screenId) {
        ticket.setScreenId(screenId);
        return this;
    }

    public TicketBuilder withSeatId(Long seatId) {
        ticket.setSeatId(seatId);
        return this;
    }

    public TicketBuilder withPaymentStatus(String paymentStatus) {
        ticket.setPaymentStatus(paymentStatus);
        return this;
    }

    public TicketBuilder withTicketStatus(String ticketStatus) {
        ticket.setTicketStatus(ticketStatus);
        return this;
    }

    public TicketBuilder withTime(Timestamp time) {
        ticket.setTime(time);
        return this;
    }

    public Ticket build() {
        return ticket;
    }
}
