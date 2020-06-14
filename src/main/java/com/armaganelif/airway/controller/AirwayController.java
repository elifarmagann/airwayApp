package com.armaganelif.airway.controller;

import com.armaganelif.airway.model.Airway;
import com.armaganelif.airway.service.AirwayService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airway")
@Api(description = "Operations related with Airway objects.")
public class AirwayController {

    @Autowired
    AirwayService airwayService;

    @GetMapping
    public ResponseEntity<Page<Airway>> findAll(Pageable pageable) {
        return ResponseEntity.ok(airwayService.findAll(pageable));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<Airway>> findByName(@PathVariable("name") String name,Pageable pageable) {
        return ResponseEntity.ok(airwayService.findByName(name, pageable));
    }

    @PostMapping
    public ResponseEntity<Airway> save(@RequestBody Airway airway) {
        return ResponseEntity.status(HttpStatus.CREATED).body(airwayService.save(airway));

    }
}
