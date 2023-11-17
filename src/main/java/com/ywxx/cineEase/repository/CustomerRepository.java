package com.ywxx.cineEase.repository;

import com.ywxx.cineEase.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
        Customer findByLastName(String lastName);
}
