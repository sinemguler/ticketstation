package com.ticketstation.model;

import com.ticketstation.model.enums.GenderType;
import com.ticketstation.model.enums.UserType;

import javax.persistence.*;


@Entity
@Table(name = "users")
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

    public User() {
    }

    public User(String name, String surname, String idNumber, GenderType genderType, String birthday, String phoneNumber, String email, String password, UserType userType) {
        this.name = name;
        this.surname = surname;
        this.idNumber = idNumber;
        this.genderType = genderType;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", genderType=" + genderType +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}
