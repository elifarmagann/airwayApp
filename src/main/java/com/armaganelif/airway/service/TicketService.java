package com.armaganelif.airway.service;

import com.armaganelif.airway.exception.NotFoundException;
import com.armaganelif.airway.model.Flight;
import com.armaganelif.airway.model.Ticket;
import com.armaganelif.airway.model.enums.Status;
import com.armaganelif.airway.repository.FlightRepository;
import com.armaganelif.airway.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    FlightService flightService;

    private static final int RAISE_CONSTANT = 10;
    private static final int ONE_HUNDRED = 100;

    private static final Logger log = LoggerFactory.getLogger(AirportService.class);

    public Ticket findByPnrNo(String pnrNo) {
        return ticketRepository.findByPnrNo(pnrNo).orElseThrow(() -> new NotFoundException("Ticket not found with given PNR No"));
    }

    @Transactional
    public Ticket save(Ticket ticket) {
        validateEntity(ticket);
        ticket.setCardNo(maskCreditCard(ticket.getCardNo()));
        ticket.setSalePrice(ticket.getFlight().getSalePrice());

        ticketRepository.save(ticket);

        updateFlightSeats(ticket);
        calculateNewPrice(ticket);
        return ticket;
    }

    @Transactional
    public Ticket cancel(Long id) {
        Ticket foundTicket = ticketRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found with given id!"));
        foundTicket.setStatus(Status.PASSIVE.getVal());

        return ticketRepository.save(foundTicket);
    }


    private void validateEntity(Ticket ticket) {
        Flight flight = flightRepository.findById(ticket.getFlight().getId()).orElseThrow(() -> new NotFoundException("Flight not found!"));
        ticket.setFlight(flight);
    }

    private String maskCreditCard(String cartNo) {
        return cartNo.replaceAll("\\D", "").replaceAll("(?<=.{6}).(?=.{4})", "*");
    }

    private void updateFlightSeats(Ticket ticket) {
        Flight flight = ticket.getFlight();
        flightService.updateSeats(flight);
    }

    private void calculateNewPrice(Ticket ticket) {
        Flight flight = ticket.getFlight();

        int filledSeats = flight.getTotalSeatNumbers() - flight.getAvailableSeatNumbers();

        int percentageOfFullness = calcPercentage(filledSeats, flight.getTotalSeatNumbers());
        int valueOfPercentageDividedByRaise = Math.floorDiv(percentageOfFullness, RAISE_CONSTANT);
        log.info("Percentage of fullness: " + percentageOfFullness);

        //        increase the price
        if (Math.floorMod((valueOfPercentageDividedByRaise * RAISE_CONSTANT), RAISE_CONSTANT) == 0) {
            BigDecimal oldPrice = flight.getPrice();
            BigDecimal newPrice = oldPrice.add(applyPercentage(oldPrice, new BigDecimal(valueOfPercentageDividedByRaise * RAISE_CONSTANT)));

            flight.setSalePrice(newPrice);
            log.info("The price increased. Current price: " + newPrice);
            flightRepository.save(flight);
        }
    }

    private static int calcPercentage(int obtained, int total) {
        return obtained * ONE_HUNDRED / total;
    }

    private static BigDecimal applyPercentage(BigDecimal number, BigDecimal perc) {
        return number.multiply(perc).divide(new BigDecimal(ONE_HUNDRED));
    }

}
