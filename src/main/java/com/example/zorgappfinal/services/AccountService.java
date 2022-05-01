package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AccountDto;
import com.example.zorgappfinal.models.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    List<AccountDto> getAllAccounts();
    AccountDto getAccountById(Long id);
    AccountDto addAccount(AccountDto dto);
    void updateAccount(Long id, AccountDto dto);
    AccountDto transfertoDto(Account account);
    Account transferToAccount(AccountDto dto);
    void addMessage(Long id, Long messageId);
    void assignUser(String username, Long id);
}
