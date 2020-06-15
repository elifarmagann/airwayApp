package com.armaganelif.airway.controller;

import com.armaganelif.airway.model.Route;
import com.armaganelif.airway.service.RouteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/route")
@Api(description = "Operations related with Route objects.")
public class RouteController {

    @Autowired
    RouteService routeService;

    @ApiOperation(value = "Search departure airport by name")
    @GetMapping("/departure-search")
    public ResponseEntity<Page<Route>> getByDeparture(@RequestParam String departureName, Pageable pageable) {
        return ResponseEntity.ok(routeService.findByDepartureName(departureName, pageable));
    }

    @ApiOperation(value = "Search destination airport according to dependent departure airport")
    @GetMapping("/destination-search")
    public ResponseEntity<Page<Route>> getByDeparture(@RequestParam Long departureAirportId, @RequestParam String destinationName, Pageable pageable) {
        return ResponseEntity.ok(routeService.findByDestinationNameAccordingToDeparture(departureAirportId, destinationName, pageable));
    }

    @PostMapping
    public ResponseEntity<Route> save(@RequestBody Route route) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.save(route));

    }
}
