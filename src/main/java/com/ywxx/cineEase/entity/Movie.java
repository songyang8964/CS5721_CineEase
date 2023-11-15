package com.ywxx.cineEase.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "MOVIE_ID")
    private long movieId;
    @Column(name = "MOVIE_POSTER_URL")
    private String moviePosterUrl;
    @Column(name = "MOVIE_TAGS")
    private String movieTags;

}
