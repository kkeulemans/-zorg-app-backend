package com.example.zorgappfinal.dto;


import java.time.LocalDate;
public class AccountDto {
    private Long id;
    String firstName;
    String lastName;
    String address;
    String sex;
    LocalDate birthdate;

    UserDto user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress(){ return address;}
    public void setAddress(String address){this.address = address;}

    public String getSex(){ return sex;}

    public void setSex(String sex){this.sex = sex;}

    public LocalDate getBirthdate(){ return birthdate;}
    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate;}
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public UserDto getUser(){ return user;}
    public void setUser(UserDto user) { this.user = user;}

}
