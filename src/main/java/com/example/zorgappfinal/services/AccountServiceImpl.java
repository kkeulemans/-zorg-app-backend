package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.AccountDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.models.Account;
import com.example.zorgappfinal.models.Appointment;
import com.example.zorgappfinal.models.Message;
import com.example.zorgappfinal.models.User;
import com.example.zorgappfinal.repositories.AccountRepository;
import com.example.zorgappfinal.repositories.AppointmentRepository;
import com.example.zorgappfinal.repositories.MessageRepository;
import com.example.zorgappfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AccountDto> getAllAccounts() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        List<Account> accounts = accountRepository.findAll();
        for (Account account : accounts) {
            AccountDto dto = transfertoDto(account);
            accountDtoList.add(dto);
        }
        return accountDtoList;

    }

    public AccountDto getAccountById(Long id) {
        if (accountRepository.findById(id).isPresent()) {
            Account account = accountRepository.findById(id).get();
            AccountDto dto = transfertoDto(account);
            return dto;
        } else {
            throw new RecordNotFoundException("No client found");
        }
    }

    public AccountDto addAccount(AccountDto dto) {
        Account accountToBeAdded = transferToAccount(dto);
        accountRepository.save(accountToBeAdded);

        return dto;

    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void updateAccount(Long id, AccountDto dto) {
        if (accountRepository.findById(id).isPresent()) {
            Account account = transferToAccount(dto);
            accountRepository.save(account);

        }
    }


    public AccountDto transfertoDto(Account account) {
        AccountDto dto = new AccountDto();

        dto.setId(account.getId());
        dto.setFirstName(account.getFirstName());
        dto.setLastName(account.getLastName());
        dto.setAddress(account.getAddress());
        dto.setSex(account.getSex());
        dto.setBirthdate(account.getBirthdate());

        return dto;

    }

    public Account transferToAccount(AccountDto dto) {
        Account account = new Account();

        account.setId(dto.getId());
        account.setFirstName(dto.getFirstName());
        account.setLastName(dto.getLastName());
        account.setAddress(dto.getAddress());
        account.setSex(dto.getSex());
        account.setBirthdate(dto.getBirthdate());
        return account;
    }

    public void addMessage(Long id, Long messageId) {

        Account account = accountRepository.getById(id);
        Message message = messageRepository.getById(messageId);

        account.addMessage(message);
        accountRepository.save(account);
    }

    public void addAppointment(Long id, Long appointmentId) {

        Account account = accountRepository.getById(id);
        Appointment appointment = appointmentRepository.getById(appointmentId);

        account.addAppointment(appointment);
        accountRepository.save(account);
    }

    public void assignUser(String username, Long accountId) {
        Optional<User> optionalUser = userRepository.findById(username);
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var account = optionalAccount.get();
            user.setAccount(account);
            account.setUser(user);

            accountRepository.save(account);

            userRepository.save(user);
        }

    }
}
