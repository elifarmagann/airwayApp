package com.armaganelif.airway.controller;

import com.armaganelif.airway.model.Airport;
import com.armaganelif.airway.model.Route;
import com.armaganelif.airway.service.RouteService;
import io.swagger.annotations.Api;
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

    @GetMapping("/departure/{departureName}")
    public ResponseEntity<Page<Route>> getByDeparture(@PathVariable String departureName, Pageable pageable) {
        return ResponseEntity.ok(routeService.findByDepartureName(departureName, pageable));
    }

//    TODO: kalkış yapılan havalimanına göre varış havalimanları aranır
    @GetMapping("/destination/{destinationName}")
    public ResponseEntity<Page<Route>> getByDeparture(@PathVariable String destinationName, @RequestParam Long departureAirportId, Pageable pageable) {
        return ResponseEntity.ok(routeService.findByDestinationNameAccordingToDeparture(departureAirportId,destinationName, pageable));
    }

    @PostMapping
    public ResponseEntity<Route> save(@RequestBody Route route) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.save(route));

    }
}