package com.ywxx.cineEase.entity;

import com.ywxx.cineEase.entity.Booking;
import com.ywxx.cineEase.entity.CinemaSeat;
import com.ywxx.cineEase.entity.Show;
import lombok.*;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "show_seat")
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_seat_id")
    private Integer showSeatId;

    @Column(name = "status")
    private Integer status;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "cinema_seat_id", referencedColumnName = "cinema_seat_id")
    private CinemaSeat cinemaSeat;

    @ManyToOne
    @JoinColumn(name = "show_id", referencedColumnName = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;


}
