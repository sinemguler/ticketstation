package com.ticketstation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketstation.model.Transport;
import com.ticketstation.model.enums.ExpeditionType;
import com.ticketstation.model.enums.TransportType;
import com.ticketstation.request.TransportRequest;



import com.ticketstation.response.TransportResponse;
import com.ticketstation.service.TransportService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TransportController.class)
public class TransportControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransportService transportService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void it_should_get_all_transport() throws Exception {

        //given
        Mockito.when(transportService.getAll()).thenReturn(getAllTransportResponses());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/transport"));

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pnrNo").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departure").value("istanbul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destination").value("ankara"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departDate").value("2020-02-02"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].seatNo").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(123));

    }

    @Test
    void it_should_create() throws Exception {

        Mockito.when(transportService.create(Mockito.any(TransportRequest.class))).thenReturn(getTransport(1));

        String request = mapper.writeValueAsString(getTransportRequest());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/transport")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pnrNo").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departure").value("istanbul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.destination").value("ankara"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.departDate").value("2020-02-02"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.seatNo").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(123))
                .andExpect(MockMvcResultMatchers.jsonPath("$.transportType").value(TransportType.BUS.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(ExpeditionType.ACTIVE.toString()));

    }

    @Test
    void it_should_get_all_transports_by_destination() throws Exception {
        Mockito.when(transportService.getAllByProvince("ankara")).thenReturn(getAllTransportResponses());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/transport/destination/ankara"));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pnrNo").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departure").value("istanbul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destination").value("ankara"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departDate").value("2020-02-02"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].seatNo").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(123));
    }

    @Test
    void it_should_get_all_transports_by_departure() throws Exception {
        Mockito.when(transportService.getAllByDeparture("istanbul")).thenReturn(getAllTransportResponses());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/transport/departure/istanbul"));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].pnrNo").value("123"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departure").value("istanbul"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].destination").value("ankara"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].departDate").value("2020-02-02"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].seatNo").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price").value(123));
    }

    private Transport getTransport(int id) {
        return new Transport(123,"istanbul", "ankara", "2020-02-02", 1, "tur",123 , TransportType.BUS, ExpeditionType.ACTIVE);
    }

    private TransportRequest getTransportRequest() {
        return new TransportRequest(123, "istanbul", "ankara", "2020-02-02", 1, "tur",123 , TransportType.BUS, ExpeditionType.ACTIVE, 1);
    }

    private List<TransportResponse> getAllTransportResponses() {
        return List.of(getTransportResponse(1));
    }

    private TransportResponse getTransportResponse(int id) {
        return new TransportResponse(id, 123, "istanbul", "ankara", "2020-02-02", 1,123,1);
    }
}

