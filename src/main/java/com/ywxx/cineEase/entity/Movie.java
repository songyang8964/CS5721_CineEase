package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "language")
    private String language;

    @Column(name = "release_date")
    private Timestamp releaseDate;

    @Column(name = "country")
    private String country;

    @Column(name = "genre")
    private String genre;

}
