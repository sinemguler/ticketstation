package com.ticketstation.response;

import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;

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


    public UserResponse() {
    }

    public UserResponse(Integer id, String name, String surname, String idNumber, GenderType genderType, String birthday, String phoneNumber, String email, UserType type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.genderType = genderType;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
