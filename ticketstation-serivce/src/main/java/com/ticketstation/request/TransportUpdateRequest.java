package com.ticketstation.request;

import com.ticketstation.model.enums.TransportType;

public class TransportUpdateRequest {
    private int id;
    private int pnrNo;
    private String departure;
    private String destination;
    private String departDate;
    private int seatNo;
    private String company;
    private double price;
    private TransportType transportType;


    public TransportUpdateRequest() {
    }

    public TransportUpdateRequest(int id, int pnrNo, String departure, String destination, String departDate, int seatNo, String company, double price, TransportType transportType) {
        this.id = id;
        this.pnrNo = pnrNo;
        this.departure = departure;
        this.destination = destination;
        this.departDate = departDate;
        this.seatNo = seatNo;
        this.company = company;
        this.price = price;
        this.transportType = transportType;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
