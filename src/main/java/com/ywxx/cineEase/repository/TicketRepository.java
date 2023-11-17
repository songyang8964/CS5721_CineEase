package com.ywxx.cineEase.repository;


import com.ywxx.cineEase.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    // List<Ticket> findByScreengId(long screenId);
}
