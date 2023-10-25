package com.ticketstation.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportResponse {
    private int id;
    private int pnrNo;
    private String departure;
    private String destination;
    private String departDate;
    private int seatNo;
    private double price;
    private Integer userId;

}
