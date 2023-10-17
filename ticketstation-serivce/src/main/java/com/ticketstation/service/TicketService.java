package com.ticketstation.service;

import com.ticketstation.client.PaymentServiceClient;
import com.ticketstation.converter.TicketConverter;
import com.ticketstation.exception.TransportException;
import com.ticketstation.exception.TicketLimitException;
import com.ticketstation.exception.UserNotFoundException;
import com.ticketstation.model.*;
import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.TransportType;
import com.ticketstation.model.enums.UserType;
import com.ticketstation.repository.TicketRepository;
import com.ticketstation.response.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TransportService transportService;

    @Autowired
    private TicketConverter ticketConverter;

    @Autowired
    private PaymentServiceClient paymentServiceClient;

    public Ticket purchaseTicket(int userId, int transportId, List<Passenger> passengers) {
        Logger logger = Logger.getLogger(TicketService.class.getName());

        Optional<User> foundUser = userService.getById(userId);
        if (!foundUser.isPresent()) {
            throw new UserNotFoundException("Kullanıcı sistemde bulunmamaktadır");
        }

        Optional<Transport> foundTransport = transportService.getById(transportId);
        if (!foundTransport.isPresent()) {
            throw new TransportException("Araç sistemde bulunmamaktadır");
        }

        Transport transport = foundTransport.get();
        User user = foundUser.get();

        long ticketCount = ticketRepository.countByUserAndTransport(user, transport);
        if (user.getUserType() == UserType.INDIVIDUAL && ticketCount >= 5) {
            throw new TicketLimitException("Bireysel kullanıcı aynı sefer için en fazla 5 bilet alabilir");
        }
        int malePassengerCount = 0;
        for (Passenger passenger : passengers) {
            if (passenger.getGenderType() == GenderType.MALE) {
                malePassengerCount++;
            }
        }
        if (user.getUserType() == UserType.INDIVIDUAL && malePassengerCount >= 2) {
            throw new TicketLimitException("Bireysel kullanıcı tek bir siparişte en fazla 2 erkek yolcu için bilet alabilir");
        }
        if (user.getUserType() == UserType.CORPORATE && ticketCount >= 20) {
            throw new TicketLimitException("Kurumsal kullanıcı aynı sefer için en fazla 20 bilet alabilir");
        }

        TransportType transportType = transport.getTransportType();
        if (transportType == TransportType.BUS && transport.getCurrentPassenger() >= Transport.getBusCapacity()) {
            throw new TransportException("Otobüs kapasitesi doludur, daha fazla bilet alamazsınız");
        } else if (transportType == TransportType.PLANE && transport.getCurrentPassenger() >= Transport.getPlaneCapacity()) {
            throw new TransportException("Uçak kapasitesi doludur, daha fazla bilet alamazsınız");
        }

        else {
            Ticket ticket = new Ticket();
            ticket.setUser(foundUser.get());
            ticket.setTransport(transport);
            ticket.setPassengers(passengers);
            for (Passenger passenger : passengers) {
                passenger.setTicket(ticket);
            }
            transport.addPassenger();

            Ticket saveTicket = ticketRepository.save(ticket);

            logger.log(Level.INFO, "[purchaseTicket] -ticket created: {0}", saveTicket.getId());
            return saveTicket;
        }
    }

    public Optional<Ticket> getById(Integer ticketId) {
        return ticketRepository.findById(ticketId);
    }

    public List<TicketResponse> getAll(){
        return ticketConverter.convert(ticketRepository.findAll());
    }

}



