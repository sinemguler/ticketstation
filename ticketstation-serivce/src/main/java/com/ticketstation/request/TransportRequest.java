package com.ticketstation.request;

import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
