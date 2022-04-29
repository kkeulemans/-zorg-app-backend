package com.example.zorgappfinal.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name ="user_id")
    User user;
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;
    @Column(name = "address")
    String address;
    @Column(name="sex")
    String sex;

    @Column
    LocalDate birthdate;

    @ManyToMany
    @JoinTable(
            name = "message_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    List<Message> messages;
    @ManyToMany
    @JoinTable(
            name = "appointment_account",
            joinColumns = @JoinColumn(name = "account_id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id"))
    List<Appointment> appointments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress(){ return address;}
    public void setAddress(String address){this.address = address;}

    public LocalDate getBirthdate(){ return birthdate;}
    public void setBirthdate(LocalDate birthdate) {this.birthdate = birthdate;}
    public String getSex(){ return sex;}

    public void setSex(String sex){this.sex = sex;}
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

    public User getUser(){ return user;}
    public void setUser(User user) { this.user = user;}

    public void addMessage (Message message){
        messages.add(message);
    }

    public void addAppointment(Appointment appointment) {appointments.add(appointment);}
}
