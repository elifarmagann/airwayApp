package com.armaganelif.airway.controller;

import com.armaganelif.airway.model.Airport;
import com.armaganelif.airway.service.AirportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airport")
@Api(description = "Operations related with Airport objects.")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping
    public ResponseEntity<Page<Airport>> getAll(Pageable pageable) {
        return ResponseEntity.ok(airportService.findAll(pageable));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<Airport>> getByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.ok(airportService.findByName(name, pageable));
    }

    @PostMapping
    public ResponseEntity<Airport> save(@RequestBody Airport airport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airportService.save(airport));
    }
}
