package com.ywxx.cineEase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SEAT")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seat {
    @Id
    @Column(name = "SEAT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seat_id;
    @Column(name = "ROW_ID")
    private char row_id;
    @Column(name = "ROW_NUMBER")
    private int row_number;
    @Column(name = "SCREEN_ID")
    private long screen_id;

}
