package com.ticketstation.converter;

import com.ticketstation.model.User;
import com.ticketstation.request.UserRequest;
import com.ticketstation.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public UserResponse convert(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setSurname(user.getSurname());
        response.setIdNumber(user.getIdNumber());
        response.setGenderType(user.getGenderType());
        response.setBirthday(user.getBirthday());
        response.setPhoneNumber(user.getPhoneNumber());
        response.setEmail(user.getEmail());
        response.setType(user.getUserType());
        return response;

    }

    public User convert(UserRequest userRequest, String hash){
        User user = new User();
        user.setName(userRequest.getName());
        user.setSurname(userRequest.getSurname());
        user.setIdNumber(userRequest.getIdNumber());
        user.setGenderType(userRequest.getGenderType());
        user.setBirthday(userRequest.getBirthday());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());
        user.setPassword(hash);
        user.setUserType(userRequest.getType());

        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : userList) {
            userResponses.add(convert(user));
        }
        return userList.stream().map(this::convert).toList();
    }
}
