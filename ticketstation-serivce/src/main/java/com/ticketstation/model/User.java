package com.ticketstation.model;

import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType genderType;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
