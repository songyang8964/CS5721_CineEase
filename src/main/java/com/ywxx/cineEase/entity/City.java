package com.ywxx.cineEase.entity;

import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    // Other fields and methods
}
