package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AppointmentDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.models.*;
import com.example.zorgappfinal.repositories.AccountRepository;
import com.example.zorgappfinal.repositories.AppointmentRepository;
import com.example.zorgappfinal.repositories.AccountAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountAppointmentServiceImpl implements AccountAppointmentService {
    @Autowired
    AccountAppointmentRepository accountAppointmentRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AppointmentRepository appointmentRepository;

    public List<AppointmentDto> getAllByAccountId(Long accountId){
        List<AppointmentDto> dtos = new ArrayList<>();
        List<AccountAppointment> accountAppointments = accountAppointmentRepository.findAllByAccountId(accountId);
        for (AccountAppointment accountAppointment : accountAppointments){
            Appointment appointment = accountAppointment.getAppointment();
            AppointmentDto dto = new AppointmentDto();

            dto.setId(appointment.getId());
            dto.setDate(appointment.getDate());
            dto.setTime(appointment.getTime());

            dtos.add(dto);
        }

        return dtos;
    }
    public AppointmentKey addUserMessage (Long appointmentId, Long accountId){
        AccountAppointment accountAppointment = new AccountAppointment();

        if (!appointmentRepository.existsById(appointmentId)) {throw new RecordNotFoundException();}
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
        if (!accountRepository.existsById(accountId)) {throw new RecordNotFoundException();}
       Account user = accountRepository.findById(accountId).orElse(null);
        accountAppointment.setAppointment(appointment);
        accountAppointment.setAccount(user);
        AppointmentKey id = new AppointmentKey(appointmentId, accountId);
        accountAppointment.setId(id);
        accountAppointmentRepository.save(accountAppointment);
        return id;
    }
}
