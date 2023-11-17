package com.ywxx.cineEase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long managerId;
    private String password;
    private String email;
}
