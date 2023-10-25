package com.ticketstation.response;

import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Integer id;
    private String name;
    private String surname;
    private String idNumber;
    private GenderType genderType;
    private String birthday;
    private String phoneNumber;
    private String email;
    private UserType type;
}
