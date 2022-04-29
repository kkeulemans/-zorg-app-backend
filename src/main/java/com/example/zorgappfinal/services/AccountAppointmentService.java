package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AppointmentDto;
import com.example.zorgappfinal.models.AppointmentKey;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface AccountAppointmentService {

    List<AppointmentDto> getAllByAccountId(Long accountId);
    AppointmentKey addUserMessage (Long appointmentId, Long accountId);
}
