package com.ywxx.cineEase.repository;

import com.ywxx.cineEase.entity.Movie;
import com.ywxx.cineEase.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}
