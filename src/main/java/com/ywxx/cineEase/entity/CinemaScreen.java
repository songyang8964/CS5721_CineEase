package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinema_screen")
public class CinemaScreen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_screen_id")
    private Integer cinemaScreenId;

    @Column(name = "name")
    private String name;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "cinema_id",insertable=false, updatable=false)
    private Integer cinemaId;

    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "cinema_id")
    private Cinema cinema;

}
