package com.example.zorgappfinal.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

    private Long id;
    private LocalDate date;
    private LocalTime time;

    public AppointmentDto() {
    }

    public AppointmentDto(Long id, LocalDate date, LocalTime time) {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

}