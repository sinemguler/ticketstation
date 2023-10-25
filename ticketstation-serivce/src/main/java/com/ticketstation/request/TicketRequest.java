package com.ticketstation.request;

import com.ticketstation.model.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private Integer userId;
    private Integer transportId;
    private List<Passenger> passengers;

}
