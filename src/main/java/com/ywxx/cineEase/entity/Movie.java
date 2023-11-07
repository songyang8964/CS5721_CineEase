package com.ywxx.cineEase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;

    @Column(unique = true)
    private String movieName;
    private String summary;
    private Integer price;
    private String actors;
    private String language;
    private Integer durationMins;
    private String genre;

    public Movie () {
    }

    public Movie(String movieName, String summary, Integer price, String actors, String language, Integer durationMins, String genre) {
      this.movieName = movieName;
      this.summary = summary;
      this.price = price;
      this.actors = actors;
      this.language = language;
      this.durationMins = durationMins;
      this.genre = genre;
    }

    @Override
    public String toString() {
        return movieId + " " + movieName;
    }
}
