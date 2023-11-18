package com.ywxx.cineEase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "SCREEN")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Screen {
    @Id
    @Column(name = "SCREEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long screenId;
    @Column(name = "THEATRE_ID")
    private long theatreId;

    private int screenNum;
    private long movieId;
    private Timestamp time;


}
