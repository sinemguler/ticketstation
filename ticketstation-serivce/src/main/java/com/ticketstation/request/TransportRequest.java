package com.ticketstation.request;

import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;

public class TransportRequest {
    private int pnrNo;
    private String departure;
    private String destination;
    private String departDate;
    private int seatNo;
    private String company;
    private double price;
    private TransportType transportType;
    private ExpeditionType status;
    private Integer userId;

    public TransportRequest() {
    }

    public TransportRequest(int pnrNo, String departure, String destination, String departDate, int seatNo, String company, double price, TransportType transportType, ExpeditionType status, Integer userId) {
        this.pnrNo = pnrNo;
        this.departure = departure;
        this.destination = destination;
        this.departDate = departDate;
        this.seatNo = seatNo;
        this.company = company;
        this.price = price;
        this.transportType = transportType;
        this.status = status;
        this.userId = userId;
    }


    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
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

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public ExpeditionType getStatus() {
        return status;
    }

    public void setStatus(ExpeditionType status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
