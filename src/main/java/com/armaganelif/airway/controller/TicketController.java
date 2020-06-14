package com.armaganelif.airway.controller;

import com.armaganelif.airway.controller.mapper.TicketMapper;
import com.armaganelif.airway.model.Ticket;
import com.armaganelif.airway.model.dto.TicketResponseDto;
import com.armaganelif.airway.service.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@Api(description = "Operations related with Purchasing and Ticket objects.")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/pnr-no/{pnrNo}")
    public ResponseEntity<TicketResponseDto> findByPnrNo(@PathVariable String pnrNo){
        return ResponseEntity.ok(TicketMapper.MAPPER.toDto(ticketService.findByPnrNo(pnrNo)));
    }

    @GetMapping("/cancel")
    public ResponseEntity<TicketResponseDto> findByPnrNo(@RequestParam Long id){
        return ResponseEntity.ok(TicketMapper.MAPPER.toDto(ticketService.cancel(id)));
    }

    @PostMapping
    public ResponseEntity<TicketResponseDto> save(@RequestBody Ticket ticket) {
        return ResponseEntity.status(HttpStatus.CREATED).body(TicketMapper.MAPPER.toDto(ticketService.save(ticket)));
    }
}
