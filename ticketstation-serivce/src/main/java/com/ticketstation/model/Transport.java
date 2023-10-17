package com.ticketstation.model;

import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;

import javax.persistence.*;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "pnr_no")
    private int pnrNo;
    @Column(name = "departure")
    private String departure;
    @Column(name = "destination")
    private String destination;
    @Column(name = "depart_date")
    private String departDate;
    @Column(name = "seat_no")
    private int seatNo;
    @Column(name = "company")
    private String company;
    @Column(name = "price")
    private double price;
    @Column(name = "transport")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ExpeditionType status;

    private static final int BUS_CAPACITY = 45;

    private static final int PLANE_CAPACITY = 189;
    @Column(name = "passenger")
    private int currentPassenger;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public Transport() {
    }

    public Transport(int pnrNo, String departure, String destination, String departDate, int seatNo, String company, double price, TransportType transportType, ExpeditionType status) {
        this.pnrNo = pnrNo;
        this.departure = departure;
        this.destination = destination;
        this.departDate = departDate;
        this.seatNo = seatNo;
        this.company = company;
        this.price = price;
        this.transportType = transportType;
        this.status = status;
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

    public ExpeditionType getStatus() {
        return status;
    }

    public void setStatus(ExpeditionType status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(int currentPassenger) {
        this.currentPassenger = currentPassenger;
    }

    public void addPassenger() {
        this.currentPassenger++;
    }

    public static int getPlaneCapacity() {
        return PLANE_CAPACITY;
    }

    public static int getBusCapacity() {
        return BUS_CAPACITY;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", pnrNo=" + pnrNo +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", departDate=" + departDate +
                ", seatNo=" + seatNo +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", transportType=" + transportType +
                ", status=" + status +
                '}';
    }

}