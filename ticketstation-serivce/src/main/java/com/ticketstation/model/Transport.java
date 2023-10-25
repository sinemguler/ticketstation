package com.ticketstation.model;

import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "transport")
@Data
@AllArgsConstructor
@NoArgsConstructor

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


}