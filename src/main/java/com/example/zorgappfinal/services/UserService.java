package com.example.zorgappfinal.services;

import com.example.zorgappfinal.RandomStringGenerator;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.exceptions.UsernameNotFoundException;
import com.example.zorgappfinal.dto.UserDto;
import com.example.zorgappfinal.models.Account;
import com.example.zorgappfinal.models.Authority;
import com.example.zorgappfinal.models.User;
import com.example.zorgappfinal.repositories.AccountRepository;
import com.example.zorgappfinal.repositories.MessageRepository;
import com.example.zorgappfinal.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;


public interface UserService {

    List<UserDto> getUsers();

    UserDto getUser(String username);

    boolean userExists(String username);

    String createUser(UserDto userDto);

    void deleteUser(String username);

    void updateUser(String username, UserDto newUser);

    Set<Authority> getAuthorities(String username);

    void addAuthority(String username, String authority);

    void removeAuthority(String username, String authority);

    void assignAccount(String username, Long accountId);



}