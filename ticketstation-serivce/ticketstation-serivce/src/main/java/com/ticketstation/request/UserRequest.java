package com.ticketstation.request;

import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;


public class UserRequest {
    private String name;
    private String surname;
    private String idNumber;
    private GenderType genderType;
    private String birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private UserType type;

    public UserRequest() {
    }

    public UserRequest(String name, String surname, String idNumber, GenderType genderType, String birthday, String phoneNumber, String email, String password, UserType type) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.genderType = genderType;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.type = type;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
