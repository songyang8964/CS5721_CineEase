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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketId;
    private long screenNum;
    private long screenId;
    private Long seatId;
    private String paymentStatus;
    private String ticketStatus;
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "customerId")
    private Customer customer;
}
