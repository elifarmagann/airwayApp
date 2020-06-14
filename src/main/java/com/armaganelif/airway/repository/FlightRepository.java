package com.armaganelif.airway.repository;

import com.armaganelif.airway.model.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

   Optional<Flight> findByFlightNo(@Param("flightNo") String flightNo);

    Page<Flight> findByRoute_Id(@Param("routeId") Long routeId, Pageable pageable);
}
