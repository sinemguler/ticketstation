package com.ticketstation.service;

import com.ticketstation.configuration.RabbitMQConfiguration;
import com.ticketstation.configuration.TicketStationEmailQueue;
import com.ticketstation.converter.UserConverter;
import com.ticketstation.model.User;
import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;
import com.ticketstation.repository.UserRepository;
import com.ticketstation.request.UserRequest;
import com.ticketstation.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserConverter userConverter;

    @Mock
    private UserRepository userRepository;
    @Mock
    private RabbitMQConfiguration rabbitMQConfiguration;

    @Mock
    private RabbitTemplate rabbitTemplate;
    @Mock
    private TicketStationEmailQueue ticketStationEmailQueue;

    @Test
    void it_should_create() {

        Mockito.when(userConverter.convert(Mockito.any(UserRequest.class), Mockito.anyString())).thenReturn(new User());

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(getUser());

        Mockito.when(userConverter.convert(Mockito.any(User.class))).thenReturn(getUserResponse());

        Mockito.when(rabbitMQConfiguration.getQueueName()).thenReturn("queue.name");

        Mockito.when(ticketStationEmailQueue.getQueueName()).thenReturn("queue.name");

        UserResponse userResponse = userService.createUser(getUserRequest());

        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getName()).isEqualTo(getUser().getName());
        assertThat(userResponse.getSurname()).isEqualTo(getUser().getSurname());
        assertThat(userResponse.getIdNumber()).isEqualTo(getUser().getIdNumber());
        assertThat(userResponse.getGenderType()).isEqualTo(getUser().getGenderType());
        assertThat(userResponse.getBirthday()).isEqualTo(getUser().getBirthday());
        assertThat(userResponse.getPhoneNumber()).isEqualTo(getUser().getPhoneNumber());
        assertThat(userResponse.getEmail()).isEqualTo(getUser().getEmail());
        assertThat(userResponse.getType()).isEqualTo(getUser().getUserType());

        verify(rabbitTemplate, times(1)).convertAndSend(Mockito.anyString(), Mockito.any(UserRequest.class));


        verify(userRepository).save(Mockito.any(User.class));

    }

    private User getUser() {
        return new User("test", "test", "12345678901", GenderType.MALE, "02.06.1998", "02120212012", "test@gmail.com", "hashPassword", UserType.INDIVIDUAL);
    }

    private UserRequest getUserRequest() {
        return new UserRequest("test", "test", "12345678901", GenderType.MALE, "02.06.1998", "02120212012", "test@gmail.com", "test123", UserType.INDIVIDUAL);
    }

    private UserResponse getUserResponse() {
        return new UserResponse(1, "test", "test", "12345678901", GenderType.MALE, "02.06.1998", "02120212012", "test@gmail.com", UserType.INDIVIDUAL);
    }
}
