package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id")
    private Integer cinemaId;

    @Column(name = "name")
    private String name;

    @Column(name = "total_cinema_screens")
    private Integer totalCinemaScreens;

    @Column(name = "city_id",insertable=false, updatable=false)
    private Integer cityId;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;
}
