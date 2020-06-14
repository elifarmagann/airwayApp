package com.armaganelif.airway.service;

import com.armaganelif.airway.model.Airway;
import com.armaganelif.airway.repository.AirwayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AirwayService {

    @Autowired
    AirwayRepository airwayRepository;

    private static final Logger log = LoggerFactory.getLogger(AirwayService.class);

    public Page<Airway> findAll(Pageable pageable) {
        return airwayRepository.findAll(pageable);
    }

    public Page<Airway> findByName(String name, Pageable pageable) {
        return airwayRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Transactional
    public Airway save(Airway airway) {
        log.info("Airway saved.");
        return airwayRepository.save(airway);
    }
}
