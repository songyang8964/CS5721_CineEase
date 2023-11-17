package com.ywxx.cineEase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "SEAT")
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seatId;

    private char column;
    private int row;

    private long screenId;
    private boolean available;
    private Timestamp time;

}
