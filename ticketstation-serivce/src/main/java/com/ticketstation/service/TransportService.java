package com.ticketstation.service;

import com.ticketstation.controller.UserController;
import com.ticketstation.converter.TransportConverter;
import com.ticketstation.exception.AdminException;
import com.ticketstation.exception.UserNotFoundException;
import com.ticketstation.model.Transport;
import com.ticketstation.model.User;
import com.ticketstation.model.enums.TransportType;
import com.ticketstation.model.enums.UserType;
import com.ticketstation.repository.TransportRepository;
import com.ticketstation.request.TransportRequest;
import com.ticketstation.request.TransportUpdateRequest;
import com.ticketstation.response.TransportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private TransportConverter transportConverter;

    @Autowired
    private UserService userService;

    public Transport create(TransportRequest transportRequest) {
        Logger logger = Logger.getLogger(UserController.class.getName());
        Optional<User> foundUser = userService.getById(transportRequest.getUserId());
        if (!foundUser.isPresent()) {
            throw new UserNotFoundException("Kullanıcı sistemde bulunmamaktadır");
        }
        if (UserType.ADMIN.equals(foundUser.get().getUserType())) {
            Transport savedTransport = transportRepository.save(transportConverter.convert(transportRequest));
            logger.log(Level.INFO, "[createTransport] - transport created: {0}", savedTransport.getId());
            return savedTransport;
        } else {
            logger.log(Level.WARNING, "Sadece adminler sefer oluşturabilir. userID : {0}", foundUser.get().getId());
            throw new AdminException("Sadece adminler sefer oluşturabilir");
        }
    }

    public List<TransportResponse> getAll() {
        return transportConverter.convert(transportRepository.findAll());
    }

    public Optional<Transport> getById(Integer transportId) {
        return transportRepository.findById(transportId);
    }

    public List<TransportResponse> getAllByProvince(String destination) {
        return getAll().stream()
                .filter(transport -> transport.getDestination().equalsIgnoreCase(destination)).toList();
    }

    public List<TransportResponse> getAllByDeparture(String departure) {
        return getAll().stream()
                .filter(transport -> transport.getDeparture().equalsIgnoreCase(departure)).toList();
    }

    public List<TransportResponse> getAllByDate(String departDate) {
        return getAll().stream()
                .filter(transport -> transport.getDepartDate().contains(departDate)).toList();
    }

    public List<Transport> getTransportType(TransportType transportType) {
        return transportRepository.findAll().stream()
                .filter(transport -> transport.getTransportType() == transportType)
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        transportRepository.deleteById(id);
    }

    public TransportResponse update(TransportUpdateRequest transportUpdateRequest) {
        Transport transport = transportRepository.findById(transportUpdateRequest.getId()).get();
        transport.setPnrNo(transportUpdateRequest.getPnrNo());
        transport.setCompany(transportUpdateRequest.getCompany());
        transport.setTransportType(transportUpdateRequest.getTransportType());
        transport.setDeparture(transportUpdateRequest.getDeparture());
        transport.setPrice(transportUpdateRequest.getPrice());
        transport.setDestination(transportUpdateRequest.getDestination());
        transport.setSeatNo(transportUpdateRequest.getSeatNo());
        transport.setDepartDate(transportUpdateRequest.getDepartDate());
        transportRepository.save(transport);
        return new TransportResponse();

    }
}
