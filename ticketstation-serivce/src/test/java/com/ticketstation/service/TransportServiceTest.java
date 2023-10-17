package com.ticketstation.service;

import com.ticketstation.converter.TransportConverter;
import com.ticketstation.model.Transport;
import com.ticketstation.model.User;
import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;
import com.ticketstation.model.enums.UserType;
import com.ticketstation.repository.TransportRepository;
import com.ticketstation.request.TransportRequest;
import com.ticketstation.response.TransportResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class TransportServiceTest {

    @InjectMocks
    private TransportService transportService;

    @Mock
    private TransportConverter transportConverter;

    @Mock
    private TransportRepository transportRepository;

    @Mock
    private UserService userService;

    @Test
    void it_should_create() {
        User user = new User();
        user.setUserType(UserType.ADMIN);

        Mockito.when(userService.getById(Mockito.anyInt())).thenReturn(Optional.of(user));

        Mockito.when(transportConverter.convert(Mockito.any(TransportRequest.class))).thenReturn(new Transport());

        Mockito.when(transportRepository.save(Mockito.any(Transport.class))).thenReturn(getTransport());

        Mockito.when(transportConverter.convert(Mockito.any(Transport.class))).thenReturn(getTransportResponse());

        Transport transport = transportService.create(getTransportRequest());

        assertThat(transport).isNotNull();
        assertThat(transport.getId()).isEqualTo(getTransport().getId());
        assertThat(transport.getPnrNo()).isEqualTo(getTransport().getPnrNo());
        assertThat(transport.getDeparture()).isEqualTo(getTransport().getDeparture());
        assertThat(transport.getDestination()).isEqualTo(getTransport().getDestination());
        assertThat(transport.getDepartDate()).isEqualTo(getTransport().getDepartDate());
        assertThat(transport.getSeatNo()).isEqualTo(getTransport().getSeatNo());
        assertThat(transport.getCompany()).isEqualTo(getTransport().getCompany());
        assertThat(transport.getPrice()).isEqualTo(getTransport().getPrice());
        assertThat(transport.getTransportType()).isEqualTo(getTransport().getTransportType());
        assertThat(transport.getStatus()).isEqualTo(getTransport().getStatus());

        verify(transportRepository).save(Mockito.any(Transport.class));

    }

    private TransportRequest getTransportRequest() {
        return new TransportRequest(123, "istanbul", "ankara", "2020-02-02", 1, "tur",123 , TransportType.BUS, ExpeditionType.ACTIVE, 1);
    }


    private TransportResponse getTransportResponse() {
        return new TransportResponse(1, 123, "istanbul", "ankara", "2020-02-02", 1,123,1);
    }

    private Transport getTransport() {
        return new Transport(123,"istanbul", "ankara", "2020-02-02", 1, "tur",123 , TransportType.BUS, ExpeditionType.ACTIVE);
    }


}
