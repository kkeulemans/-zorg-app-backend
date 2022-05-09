package com.example.zorgappfinal.controller;

import com.example.zorgappfinal.dto.AccountDto;
import com.example.zorgappfinal.dto.MessageDto;
import com.example.zorgappfinal.services.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/all")
    public ResponseEntity<List<AccountDto>> getAllAccounts (){
        List<AccountDto> dtos = accountService.getAllAccounts();
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/{id}")
    public AccountDto getAccountById(@PathVariable("id") Long id){
        AccountDto dto = accountService.getAccountById(id);
        return dto;
    }


    @GetMapping("/{id}/appointments")
    @PostMapping("/new")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto dto){
        accountService.addAccount(dto);
        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}")
    public AccountDto updateAccount (@PathVariable("id") Long id, @RequestBody AccountDto dto) {
        accountService.updateAccount(id, dto);
        return dto;
    }

    @PutMapping("{id}/{username}")
    public void assignToUser (@PathVariable("id") Long id, @PathVariable("username") String username){
        accountService.assignUser(username,id);
    }

    @PutMapping("{id}/message/{messageId}")
    public void assignMessage (@PathVariable("id") Long id, @PathVariable("messageId") Long messageId ){
        accountService.addMessage(id,messageId);
    }

    @PutMapping("{id}/appointment/{appointmentId}")
    public void assignAppointment (@PathVariable("id") Long id, @PathVariable("appointmentId") Long appointmentId){
        accountService.addAppointment(id, appointmentId);
    }
}
