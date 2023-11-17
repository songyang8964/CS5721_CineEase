package com.ywxx.cineEase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieId;
    @Column(unique = true, name = "MOVIE_NAME" )
    private String movieName;
    @Column(name = "SUMMARY")
    private String summary;
    @Column(name = "PRICE")
    private Integer price;
    @Column(name = "ACTORS")
    private String actors;
    @Column(name = "LANGUAGE")
    private String language;
    @Column(name = "DURATION_MINS")
    private Integer durationMins;
    @Column(name = "GENRE")
    private String genre;

}
