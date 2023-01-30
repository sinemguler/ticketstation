package com.ticketstation.controller;


import com.ticketstation.model.Transport;
import com.ticketstation.model.enums.TransportType;
import com.ticketstation.request.TransportRequest;
import com.ticketstation.request.TransportUpdateRequest;
import com.ticketstation.response.TransportResponse;
import com.ticketstation.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/transport")
public class TransportController {
    @Autowired
    private TransportService transportService;

    @GetMapping
    public ResponseEntity<List<TransportResponse>> getAll() {
        return ResponseEntity.ok(transportService.getAll());
    }

    @PostMapping
    public ResponseEntity<Transport> create(@RequestBody TransportRequest transportRequest) {
        Transport transport = transportService.create(transportRequest);
        return new ResponseEntity<>(transport, HttpStatus.CREATED);
    }

    @GetMapping(value ="/destination/{destination}")
    public List<TransportResponse> getSearchedProvince(@PathVariable String destination){
        return transportService.getAllByProvince(destination);
    }
    @GetMapping(value ="/departure/{departure}")
    public List<TransportResponse> getSearchedDeparture(@PathVariable String departure){
        return transportService.getAllByDeparture(departure);
    }
    @GetMapping(value ="/date/{date}")
    public List<TransportResponse> getAllByDate(@PathVariable String departureDate){
        return transportService.getAllByDate(departureDate);
    }
    @GetMapping("/transportType/{transportType}")
    public ResponseEntity<List<Transport>> getTransportType(@PathVariable TransportType transportType) {
        List<Transport> transport = transportService.getTransportType(transportType);
        return ResponseEntity.ok(transport);
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        transportService.delete(id);
        return "deleted " + id;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TransportResponse> update(@PathVariable int id, @RequestBody TransportUpdateRequest transportUpdateRequest){
        transportUpdateRequest.setId(id);
        TransportResponse transportResponse = transportService.update(transportUpdateRequest);
        return  new ResponseEntity<>(transportResponse, HttpStatus.OK);
    }
}
