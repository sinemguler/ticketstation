package com.ticketstation.response;


import com.ticketstation.model.Passenger;

import java.util.List;

public class TicketResponse {
    private int id;
    private Integer userId;
    private Integer transportId;
    private List<Passenger> passengers;

    public TicketResponse() {
    }

    public TicketResponse(int id, Integer userId, Integer transportId) {
        this.id = id;
        this.userId = userId;
        this.transportId = transportId;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
