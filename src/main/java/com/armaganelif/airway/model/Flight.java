package com.armaganelif.airway.model;

import com.armaganelif.airway.util.SqlTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;
import java.util.Set;

@Table(name = "flight")
@Entity
public class Flight extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String flightNo;

    @Column(nullable = false)
    private Date flightDate;

    @JsonDeserialize(using = SqlTimeDeserializer.class)
    @Column(nullable = false)
    private Time flightTime;

    @Column(nullable = false)
    private Integer totalSeatNumbers;

    @Column(nullable = false)
    private Integer availableSeatNumbers;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal salePrice;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "airway_id", nullable = false)
    private Airway airway;

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private Set<Ticket> tickets;

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public Integer getTotalSeatNumbers() {
        return totalSeatNumbers;
    }

    public void setTotalSeatNumbers(Integer totalSeatNumbers) {
        this.totalSeatNumbers = totalSeatNumbers;
    }

    public Integer getAvailableSeatNumbers() {
        return availableSeatNumbers;
    }

    public void setAvailableSeatNumbers(Integer availableSeatNumbers) {
        this.availableSeatNumbers = availableSeatNumbers;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Airway getAirway() {
        return airway;
    }

    public void setAirway(Airway airway) {
        this.airway = airway;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
