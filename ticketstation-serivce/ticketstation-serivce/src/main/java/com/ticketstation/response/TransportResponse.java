package com.ticketstation.response;

public class TransportResponse {
    private int id;
    private int pnrNo;
    private String departure;
    private String destination;
    private String departDate;
    private int seatNo;
    private double price;
    private Integer userId;

    public TransportResponse() {
    }

    public TransportResponse(Integer id, int pnrNo, String departure, String destination, String departDate, int seatNo, double price,Integer userId) {
        this.id = id;
        this.pnrNo = pnrNo;
        this.departure = departure;
        this.destination = destination;
        this.departDate = departDate;
        this.seatNo = seatNo;
        this.price = price;
        this.userId=userId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
