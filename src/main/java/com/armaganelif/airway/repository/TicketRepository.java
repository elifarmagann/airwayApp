package com.armaganelif.airway.repository;

import com.armaganelif.airway.model.Route;
import com.armaganelif.airway.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByPnrNo(@Param("pnrNo") String pnrNo);
}
