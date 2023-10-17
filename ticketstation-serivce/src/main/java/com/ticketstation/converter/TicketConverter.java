package com.ticketstation.converter;


import com.ticketstation.model.Ticket;
import com.ticketstation.model.Transport;
import com.ticketstation.model.User;
import com.ticketstation.request.TicketRequest;
import com.ticketstation.response.TicketResponse;
import com.ticketstation.service.TransportService;
import com.ticketstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TicketConverter {

    @Autowired
    private UserService userService;
    @Autowired
    private TransportService transportService;

    public TicketResponse convert(Ticket ticket) {
        TicketResponse response = new TicketResponse();
        response.setId(ticket.getId());
        response.setUserId(ticket.getUser().getId());
        response.setTransportId(ticket.getTransport().getId());
        response.setPassengers(ticket.getPassengers());
        return response;

    }

    public Ticket convert(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        if (ticketRequest.getUserId() != null && ticketRequest.getTransportId() !=null) {
            Optional<User> foundUser = userService.getById(ticketRequest.getUserId());
            Optional<Transport> foundTransport = transportService.getById(ticketRequest.getTransportId());
            if(foundUser.isPresent() && foundTransport.isPresent()) {
                ticket.setUser(foundUser.get());
                ticket.setTransport(foundTransport.get());
            }
        }
        return ticket;
    }

    public List<TicketResponse> convert(List<Ticket> ticketList) {
        List<TicketResponse> ticketResponse = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            ticketResponse.add(convert(ticket));
        }
        return ticketList.stream().map(this::convert).toList();
    }
}
