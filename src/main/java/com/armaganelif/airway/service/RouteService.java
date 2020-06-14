package com.armaganelif.airway.service;

import com.armaganelif.airway.exception.NotFoundException;
import com.armaganelif.airway.model.Airport;
import com.armaganelif.airway.model.Flight;
import com.armaganelif.airway.model.Route;
import com.armaganelif.airway.model.Ticket;
import com.armaganelif.airway.repository.AirportRepository;
import com.armaganelif.airway.repository.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    AirportRepository airportRepository;

    private static final Logger log = LoggerFactory.getLogger(AirportService.class);

    public Page<Route> findByDepartureName(String departureName, Pageable pageable) {
        return routeRepository.findByDeparture_NameContainingIgnoreCase(departureName, pageable);
    }

    public Page<Route> findByDestinationNameAccordingToDeparture(Long departureId, String destinationName, Pageable pageable) {
        return routeRepository.findByDeparture_IdAndDestination_NameContainingIgnoreCase(departureId, destinationName, pageable);
    }

    @Transactional
    public Route save(Route route) {
        validateEntity(route);

        return routeRepository.save(route);
    }

    private void validateEntity(Route route) {
        Airport departure = airportRepository.findById(route.getDeparture().getId()).orElseThrow(() -> new NotFoundException("Departure airport not found!"));
        Airport destination = airportRepository.findById(route.getDestination().getId()).orElseThrow(() -> new NotFoundException("Destination airport not found!"));

        route.setDeparture(departure);
        route.setDeparture(destination);
    }
}
