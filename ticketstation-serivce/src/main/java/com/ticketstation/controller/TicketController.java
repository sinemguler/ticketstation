package com.ticketstation.controller;


import com.ticketstation.model.Ticket;
import com.ticketstation.request.TicketRequest;
import com.ticketstation.response.TicketResponse;
import com.ticketstation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAll() {
        return ResponseEntity.ok(ticketService.getAll());
    }

    @PostMapping
    public Ticket purchaseTicket(@RequestBody TicketRequest ticketRequest) {
        return ticketService.purchaseTicket(ticketRequest.getUserId(),
                ticketRequest.getTransportId(),
                ticketRequest.getPassengers());
    }

}

