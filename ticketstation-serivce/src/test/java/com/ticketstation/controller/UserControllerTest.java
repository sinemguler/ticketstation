package com.ticketstation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;
import com.ticketstation.request.UserRequest;
import com.ticketstation.response.UserResponse;
import com.ticketstation.service.UserService;
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

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void itShouldGetAllUsers() throws Exception {

        //given
        Mockito.when(userService.getAll()).thenReturn(getAllUserResponses());

        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/users"));

        //then
        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].idNumber").value("12345678901"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].genderType").value(GenderType.MALE.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].birthday").value("02.06.1998"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber").value("02120212012"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("test@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value(UserType.INDIVIDUAL.toString()));
    }

    @Test
    void itShouldCreate() throws Exception {

        Mockito.when(userService.createUser(Mockito.any(UserRequest.class))).thenReturn(getUserResponse(1));

        String request = mapper.writeValueAsString(getUserRequest());

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.idNumber").value("12345678901"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.genderType").value(GenderType.MALE.toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.birthday").value("02.06.1998"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("02120212012"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("test@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.type").value(UserType.INDIVIDUAL.toString()));
    }

    private UserRequest getUserRequest() {
        return new UserRequest("test", "test", "12345678901", GenderType.MALE, "02.06.1998", "02120212012", "test@gmail.com", "test123", UserType.INDIVIDUAL);
    }

    private List<UserResponse> getAllUserResponses() {
        return List.of(getUserResponse(1));
    }

    private UserResponse getUserResponse(int id) {
        return new UserResponse(id, "test", "test", "12345678901", GenderType.MALE, "02.06.1998", "02120212012", "test@gmail.com", UserType.INDIVIDUAL);
    }

}
