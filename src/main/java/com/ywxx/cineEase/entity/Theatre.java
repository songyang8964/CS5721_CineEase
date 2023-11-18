package com.ywxx.cineEase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "THEATRE")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Theatre {
    @Id
    @Column(name = "THEATRE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long theatreId;
    @Column(name = "THEATRE_NAME")
    private String theatreName;
    @Column(name = "THEATRE_CITY")
    private String theatreCity;

}
