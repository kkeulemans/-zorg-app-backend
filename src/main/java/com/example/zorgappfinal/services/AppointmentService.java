package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AppointmentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AppointmentService {
    public List<AppointmentDto> getAllAppointments();
    public AppointmentDto getAppointmentById(Long id);
    AppointmentDto addAppointment (AppointmentDto appointmentDto);
    void updateAppointment(Long id, AppointmentDto appointment);
}
