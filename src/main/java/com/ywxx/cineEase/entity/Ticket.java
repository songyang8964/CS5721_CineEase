package com.ywxx.cineEase.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @Column(name = "TICKET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;
    @Column(name = "SCREENING_ID")
    private long screeningId;
    @Column(name = "SEAT_NUM")
    private int seatNum;

}
