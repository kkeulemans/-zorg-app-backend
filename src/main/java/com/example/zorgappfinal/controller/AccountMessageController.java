package com.example.zorgappfinal.controller;

import com.example.zorgappfinal.services.AccountMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountMessageController {

    private AccountMessageServiceImpl accountMessageService;

    @Autowired
    public AccountMessageController (AccountMessageServiceImpl accountMessageService){
        this.accountMessageService = accountMessageService;
    }

    @PostMapping("/{accountId}/{messageId}")
    public void addUserMessage(@PathVariable("accountId") Long accountId, @PathVariable("messageId") Long messageId) {
        accountMessageService.addUserMessage(accountId, messageId);
    }
}
