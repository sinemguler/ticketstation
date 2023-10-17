package com.ticketstation.repository;

import com.ticketstation.model.Ticket;
import com.ticketstation.model.Transport;
import com.ticketstation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer>{
        List<Ticket> findByUserIdAndTransportId(int userId, int transportId);
        Long countByUserAndTransport(User user, Transport transport);
}
