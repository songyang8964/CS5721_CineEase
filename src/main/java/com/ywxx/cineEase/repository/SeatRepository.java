package com.ywxx.cineEase.repository;

import com.ywxx.cineEase.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    public List<Seat> findByScreenId(long screenId);
}
