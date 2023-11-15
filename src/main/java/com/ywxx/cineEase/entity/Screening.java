package com.ywxx.cineEase.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "SCREENING")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Screening implements Cloneable {
    @Id
    @Column(name = "SCREENING_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screeningId;
    @Column(name = "THEATRE_ID")
    private long theatreId;
    @Column(name = "SCREEN_ID")
    private long screenId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "SCREENING_DATE")
    private Date screeningDate;
    @Column(name = "SCREENING_TIME")
    private Time screeningTime;
    @Column(name = "BOOKED_TICKETS")
    private int bookedTickets;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}
