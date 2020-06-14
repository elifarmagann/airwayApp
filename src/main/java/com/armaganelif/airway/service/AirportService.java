package com.armaganelif.airway.service;

import com.armaganelif.airway.exception.NotFoundException;
import com.armaganelif.airway.model.Airport;
import com.armaganelif.airway.model.Airway;
import com.armaganelif.airway.repository.AirportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    private static final Logger log = LoggerFactory.getLogger(AirportService.class);

    public Page<Airport> findAll(Pageable pageable) {
        return airportRepository.findAll(pageable);
    }

    public Page<Airport> findByName(String name, Pageable pageable) {
        return airportRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Transactional
    public Airport save(Airport airport) {
        log.info("Airport saved.");
        return airportRepository.save(airport);
    }

    public Airport findById(Long id) {
        return airportRepository.findById(id).orElse(null);
    }

}
