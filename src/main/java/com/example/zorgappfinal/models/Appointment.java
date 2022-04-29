package com.example.zorgappfinal.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;


    public Long getId(){
        return id;
    }
    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }


    public void setId(Long id){
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


}
