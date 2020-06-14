package com.armaganelif.airway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Table(name = "route")
@Entity
public class Route extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "departure_id" , nullable = false)
    private Airport departure;

    @ManyToOne
    @JoinColumn(name = "destination_id" , nullable = false)
    private Airport destination;

    @JsonIgnore
    @OneToMany(mappedBy = "route")
    private Set<Flight> flights;

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
