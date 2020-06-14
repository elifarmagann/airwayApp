package com.armaganelif.airway.service;

import com.armaganelif.airway.exception.NotFoundException;
import com.armaganelif.airway.model.Airway;
import com.armaganelif.airway.model.Flight;
import com.armaganelif.airway.model.Route;
import com.armaganelif.airway.repository.AirwayRepository;
import com.armaganelif.airway.repository.FlightRepository;
import com.armaganelif.airway.repository.RouteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    AirwayRepository airwayRepository;

    static final Logger log = LoggerFactory.getLogger(FlightService.class);

    public Page<Flight> findAll(Pageable pageable) {
        return flightRepository.findAll(pageable);
    }

    public Flight findByFlightNo(String flightNo) {
        return flightRepository.findByFlightNo(flightNo).orElseThrow(() -> new NotFoundException("Flight not found with given FlightNo!"));
    }

    public Page<Flight> findByRouteId(Long routeId, Pageable pageable) {
        return flightRepository.findByRoute_Id(routeId, pageable);
    }

    @Transactional
    public Flight save(Flight flight) {
        validateEntity(flight);
        return flightRepository.save(flight);
    }

    private void validateEntity(Flight flight) {
        Route route = routeRepository.findById(flight.getRoute().getId()).orElseThrow(() -> new NotFoundException("Route not found!"));
        Airway airway = airwayRepository.findById(flight.getAirway().getId()).orElseThrow(() -> new NotFoundException("Airway not found!"));

        flight.setRoute(route);
        flight.setAirway(airway);
    }

    @Transactional
    public void updateSeats(Flight flight) {
        flight.setAvailableSeatNumbers(flight.getAvailableSeatNumbers() - 1);

        flightRepository.save(flight);
    }
}
