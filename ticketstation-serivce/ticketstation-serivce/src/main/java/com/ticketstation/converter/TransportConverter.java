package com.ticketstation.converter;

import com.ticketstation.model.Transport;
import com.ticketstation.model.User;

import com.ticketstation.request.TransportRequest;

import com.ticketstation.response.TransportResponse;
import com.ticketstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TransportConverter {
    @Autowired
    private UserService userService;

    public TransportResponse convert(Transport transport){
        TransportResponse response = new TransportResponse();
        response.setId(transport.getId());
        response.setPnrNo(transport.getPnrNo());
        response.setDeparture(transport.getDeparture());
        response.setDestination(transport.getDestination());
        response.setDepartDate(transport.getDepartDate());
        response.setSeatNo(transport.getSeatNo());
        response.setPrice(transport.getPrice());
        return response;
    }

    public Transport convert(TransportRequest transportRequest){
        Transport transport = new Transport();
        transport.setPnrNo(transportRequest.getPnrNo());
        transport.setDeparture(transportRequest.getDeparture());
        transport.setDestination(transportRequest.getDestination());
        transport.setDepartDate(transportRequest.getDepartDate());
        transport.setSeatNo(transportRequest.getSeatNo());
        transport.setCompany(transportRequest.getCompany());
        transport.setTransportType(transportRequest.getTransportType());
        transport.setStatus(transportRequest.getStatus());
        transport.setPrice(transportRequest.getPrice());
        if (transportRequest.getUserId() != null) {
            Optional<User> foundUser = userService.getById(transportRequest.getUserId());
            if(foundUser.isPresent()) {
                transport.setUser(foundUser.get());
            }
        }
        return transport;
    }

    public List<TransportResponse> convert(List<Transport> transportList) {
        List<TransportResponse> transportResponses = new ArrayList<>();

        for (Transport transport : transportList) {
            transportResponses.add(convert(transport));
        }
        return transportList.stream().map(this::convert).toList();
    }
}
