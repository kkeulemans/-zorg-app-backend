package com.example.zorgappfinal.controller;

import com.example.zorgappfinal.services.AccountAppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appt")
public class AccountAppointmentController {

    private AccountAppointmentServiceImpl accountAppointmentService;

    @Autowired
    public AccountAppointmentController (AccountAppointmentServiceImpl accountAppointmentService){
        this.accountAppointmentService = accountAppointmentService;
    }

    @PostMapping("/{accountId}/{messageId}")
    public void addUserMessage(@PathVariable("accountId") Long accountId, @PathVariable("messageId") Long messageId) {
        accountAppointmentService.addUserMessage(accountId, messageId);
    }
}
