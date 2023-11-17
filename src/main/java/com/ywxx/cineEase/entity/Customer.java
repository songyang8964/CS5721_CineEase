package com.ywxx.cineEase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String password;

    //should have basic, standard, and Premium Customer with different discount (For Factory Pattern)!!!!!!!!!!!

}