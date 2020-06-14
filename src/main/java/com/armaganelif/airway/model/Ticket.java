package com.armaganelif.airway.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "ticket")
@Entity
@Where(clause = "status=1")
public class Ticket extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String pnrNo;

    private String cardNo;

    private BigDecimal salePrice;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id" , nullable = false)
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_id" , nullable = false)
    private Flight flight;

    public String getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
