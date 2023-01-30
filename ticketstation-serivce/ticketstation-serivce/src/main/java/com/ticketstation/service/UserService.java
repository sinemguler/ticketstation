package com.ticketstation.service;

import com.ticketstation.configuration.RabbitMQConfiguration;
import com.ticketstation.configuration.TicketStationEmailQueue;
import com.ticketstation.controller.UserController;
import com.ticketstation.converter.UserConverter;

import com.ticketstation.exception.UserNotFoundException;
import com.ticketstation.model.User;
import com.ticketstation.repository.UserRepository;
import com.ticketstation.request.LoginRequest;
import com.ticketstation.request.UserRequest;
import com.ticketstation.request.UserUpdateRequest;
import com.ticketstation.response.UserResponse;
import com.ticketstation.util.PasswordUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final String LOGIN_SUCCESSFUL = "Login Başarılı";
    private static final String EMAIL_OR_PASSWORD_WRONG = "Email Veya Şifre Yanlış";
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQConfiguration rabbitMQConfiguration;

    @Autowired
    private TicketStationEmailQueue ticketStationEmailQueue;

    public UserResponse createUser(UserRequest userRequest) {
        Logger logger = Logger.getLogger(UserController.class.getName());
        String hash = PasswordUtil.preparePasswordHash(userRequest.getPassword(), userRequest.getEmail());
        logger.log(Level.INFO, "[createUser] - password hash created: {0}", hash);
        User saveUser = userRepository.save(userConverter.convert(userRequest, hash));
        logger.log(Level.INFO, "[createUser] - user created: {0}", saveUser.getId());
        rabbitTemplate.convertAndSend(rabbitMQConfiguration.getQueueName(), userRequest);
        logger.log(Level.WARNING, "[createUser] - userRequest: {0}, sent to : {1}",
                new Object[]{userRequest.getEmail(), rabbitMQConfiguration.getQueueName()});
        rabbitTemplate.convertAndSend(ticketStationEmailQueue.getQueueName(), userRequest.getEmail());
        return userConverter.convert(saveUser);
    }

    public List<UserResponse> getAll(){
        return userConverter.convert(userRepository.findAll());
    }

    public Optional<User> getById(Integer userId) {
        return userRepository.findById(userId);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }

    public UserResponse update(UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(userUpdateRequest.getId()).get();
        user.setName(userUpdateRequest.getName());
        user.setSurname(userUpdateRequest.getSurname());
        user.setPhoneNumber(userUpdateRequest.getPhoneNumber());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPassword(userUpdateRequest.getPassword());
        userRepository.save(user);
        return new UserResponse();

    }

    public String login(LoginRequest loginRequest) {
        User foundUser = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        String passwordHash = PasswordUtil.preparePasswordHash(loginRequest.getPassword(), loginRequest.getEmail());

        boolean isValid = PasswordUtil.validatePassword(passwordHash, foundUser.getPassword());

        return isValid ? LOGIN_SUCCESSFUL : EMAIL_OR_PASSWORD_WRONG;
    }

}