package com.ywxx.cineEase.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {
    @Id
    @Column(name = "TICKET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;
    private long screenNum;
    private long screenId;
    private Long seatId;
    private Long customerId;
    private String paymentStatus;
    private String ticketStatus;
    private Long orderId;
    private Timestamp time;



}
