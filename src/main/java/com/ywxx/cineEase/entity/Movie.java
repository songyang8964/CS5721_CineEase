package com.ywxx.cineEase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieId;
    private String name;

    public Movie () {
    }

    public Movie(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
               "id=" + movieId +
               ", title='" + name + '\'' +
               '}';
    }
}
