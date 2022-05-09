package com.example.zorgappfinal.services;

import com.example.zorgappfinal.RandomStringGenerator;
import com.example.zorgappfinal.dto.UserDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.exceptions.UsernameNotFoundException;
import com.example.zorgappfinal.models.Account;
import com.example.zorgappfinal.models.Authority;
import com.example.zorgappfinal.models.User;
import com.example.zorgappfinal.repositories.AccountRepository;

import com.example.zorgappfinal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;



    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for (User user : list) {
            collection.add(transferFromUser(user));
        }
        return collection;
    }

    public UserDto getUser(String username) {
        Optional<User> user = userRepository.findById(username);
        if (user.isPresent()) {
           UserDto dto = transferFromUser(user.get());
           return dto;
        } else {
            throw new UsernameNotFoundException(username);
        }

    }

    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }

    public String createUser(UserDto userDto) {
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        userDto.setApikey(randomString);
        User newUser = userRepository.save(transferToUser(userDto));
        return newUser.getUsername();
    }

    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    public void updateUser(String username, UserDto newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }

    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        UserDto userDto = transferFromUser(user);
        return userDto.getAuthorities();
    }

    public void addAuthority(String username, String authority) {

        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

    public static UserDto transferFromUser(User user) {

        var dto = new UserDto();

        dto.setUsername(user.getUsername());
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.setEmail(user.getEmail());
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User transferToUser(UserDto userDto) {

        var user = new User();
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEnabled(userDto.getEnabled());
        user.setApikey(userDto.getApikey());


        return user;
    }



}
