package com.ticketstation.controller;

import com.ticketstation.request.LoginRequest;
import com.ticketstation.request.UserRequest;
import com.ticketstation.request.UserUpdateRequest;
import com.ticketstation.response.UserResponse;
import com.ticketstation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "deleted " + id;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable int id, @RequestBody UserUpdateRequest userUpdateRequest){
        userUpdateRequest.setId(id);
        UserResponse userResponse = userService.update(userUpdateRequest);
        return  new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        return  ResponseEntity.ok(userService.login(loginRequest));
    }

}
