package com.armaganelif.airway.repository;

import com.armaganelif.airway.model.Route;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    Page<Route> findByDeparture_NameContainingIgnoreCase(@Param("departureName") String departureName, Pageable pageable);
    Page<Route> findByDeparture_IdAndDestination_NameContainingIgnoreCase(@Param("departureId") Long departureId,  @Param("destinationName") String destinationName, Pageable pageable);
}
