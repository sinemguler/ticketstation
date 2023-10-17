package com.ticketstation.request;

import com.ticketstation.model.Passenger;

import java.util.List;

public class TicketRequest {
    private Integer userId;
    private Integer transportId;

    private List<Passenger> passengers;

    public TicketRequest() {
    }

    public TicketRequest(Integer userId, Integer transportId, List<Passenger> passengers) {
        this.userId = userId;
        this.transportId = transportId;
        this.passengers = passengers;
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
