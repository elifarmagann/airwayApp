package com.armaganelif.airway.repository;

import com.armaganelif.airway.model.Airport;
import com.armaganelif.airway.model.Airway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirwayRepository extends JpaRepository<Airway, Long> {

    Page<Airway> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

}
