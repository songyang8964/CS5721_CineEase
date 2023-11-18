package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cinema_seat")
public class CinemaSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_seat_id")
    private Integer cinemaSeatId;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "type")
    private Integer type;

    @ManyToOne
    @JoinColumn(name = "cinema_screen_id", referencedColumnName = "cinema_screen_id")
    private CinemaScreen cinemaScreen;

}
