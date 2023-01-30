package com.ticketstation.repository;

import com.ticketstation.model.Transport;
import com.ticketstation.model.enums.TransportType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransportRepository extends JpaRepository<Transport,Integer> {

    List<Transport> findByTransportType(TransportType transportType);
}
