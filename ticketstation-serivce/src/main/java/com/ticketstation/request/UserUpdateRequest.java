package com.ticketstation.request;

import com.ticketstation.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType type;
}
