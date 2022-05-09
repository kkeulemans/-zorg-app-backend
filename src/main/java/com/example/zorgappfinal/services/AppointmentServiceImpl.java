package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.MessageDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.dto.AppointmentDto;
import com.example.zorgappfinal.models.Account;
import com.example.zorgappfinal.models.Appointment;
import com.example.zorgappfinal.models.Message;
import com.example.zorgappfinal.repositories.AccountRepository;
import com.example.zorgappfinal.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointmentList = appointmentRepository.findAll();
        List<AppointmentDto> appointmentDtoList = new ArrayList<>();


        for (Appointment appointment : appointmentList) {
            AppointmentDto dto = transferToDto(appointment);
            appointmentDtoList.add(dto);
        }
        return appointmentDtoList;
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return transferToDto(appointment.get());
        } else {
            throw new RecordNotFoundException("No remotecontroller found");
        }
    }

    public List<AppointmentDto> getAppointmentsByAccountId(Long id){
        Account account = accountRepository.getById(id);
        List<Appointment> appointments = account.getAppointments();
        List<AppointmentDto> dtos = new ArrayList<>();

        for (Appointment appointment : appointments){
            AppointmentDto dto = transferToDto(appointment);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        Appointment appointmentToBeAdded = transferToAppointment(appointmentDto);
        appointmentRepository.save(appointmentToBeAdded);
        appointmentDto.setId(appointmentToBeAdded.getId());
        return appointmentDto;
    }


    @Override
    public void updateAppointment(Long id, AppointmentDto appointment) {
        appointment.setId(id);
        if (!appointmentRepository.existsById(id)) {
            throw new RecordNotFoundException("No appointment found");
        }
        Appointment storedAppointment = appointmentRepository.findById(id).orElse(null);
        storedAppointment.setId(appointment.getId());
        storedAppointment.setDate(appointment.getDate());
        storedAppointment.setTime(appointment.getTime());
        appointmentRepository.save(storedAppointment);

    }


    public AppointmentDto transferToDto(Appointment appointment) {
        var dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setTime(appointment.getTime());

        return dto;
    }

    public Appointment transferToAppointment(AppointmentDto appointmentDto) {
        var appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setTime(appointmentDto.getTime());
        appointment.setDate(appointmentDto.getDate());

        return appointment;
    }


}


