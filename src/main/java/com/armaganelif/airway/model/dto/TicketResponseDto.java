package com.armaganelif.airway.model.dto;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;

public class TicketResponseDto extends BaseDto {
    private String pnrNo;
    private String cardNo;
    private BigDecimal salePrice;
    private String flightNo;
    private Date flightDate;
    private Time flightTime;
    private String departure;
    private String destination;
    private String customerName;
    private String customerFamilyName;


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

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerFamilyName() {
        return customerFamilyName;
    }

    public void setCustomerFamilyName(String customerFamilyName) {
        this.customerFamilyName = customerFamilyName;
    }
}
