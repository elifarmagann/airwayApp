package com.armaganelif.airway.controller;

import com.armaganelif.airway.model.Flight;
import com.armaganelif.airway.service.FlightService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flight")
@Api(description = "Operations related with Flight objects.")
public class FlightController {


    @Autowired
    FlightService flightService;

    @GetMapping
    public ResponseEntity<Page<Flight>> getAll(Pageable pageable) {
        return ResponseEntity.ok(flightService.findAll(pageable));
    }

    @GetMapping("/flight-number/{flightNumber}")
    public ResponseEntity<Flight> getByFlightNo(@PathVariable String flightNumber) {
        return ResponseEntity.ok(flightService.findByFlightNo(flightNumber));
    }


    @GetMapping("/route-id/{routeId}")
    public ResponseEntity<Page<Flight>> getByRouteId(@PathVariable Long routeId, Pageable pageable) {
        return ResponseEntity.ok(flightService.findByRouteId(routeId, pageable));
    }

    @PostMapping
    public ResponseEntity<Flight> save(@RequestBody Flight flight) {
        return ResponseEntity.status(HttpStatus.CREATED).body(flightService.save(flight));
    }
}
