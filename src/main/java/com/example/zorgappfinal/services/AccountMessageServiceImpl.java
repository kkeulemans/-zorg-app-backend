package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.MessageDto;
import com.example.zorgappfinal.exceptions.RecordNotFoundException;
import com.example.zorgappfinal.models.*;
import com.example.zorgappfinal.repositories.AccountMessageRepository;
import com.example.zorgappfinal.repositories.AccountRepository;
import com.example.zorgappfinal.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountMessageServiceImpl implements AccountMessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private AccountMessageRepository accountMessageRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Override
   public List<MessageDto> getAllByAccountId(Long accountId){
        List<MessageDto> messageDtos = new ArrayList<>();
        List<AccountMessage> accountMessages = accountMessageRepository.findAllByAccountId(accountId);
        for (AccountMessage accountMessage : accountMessages) {
            Message message = accountMessage.getMessage();
            MessageDto dto = new MessageDto();

            dto.setId(message.getId());
            dto.setTitle(message.getTitle());
            dto.setBody(message.getBody());

            messageDtos.add(dto);
        }
        return  messageDtos;
    }
   @Override
    public MessageKey addUserMessage (Long messageId, Long accountId){
       AccountMessage accountMessage = new AccountMessage();

       if (!messageRepository.existsById(messageId)) {throw new RecordNotFoundException();}
       Message message = messageRepository.findById(messageId).orElse(null);
       if (!accountRepository.existsById(accountId)) {throw new RecordNotFoundException();}
      Account user = accountRepository.findById(accountId).orElse(null);
       accountMessage.setMessage(message);
       accountMessage.setAccount(user);
       MessageKey id = new MessageKey(messageId, accountId);
       accountMessage.setId(id);
       accountMessageRepository.save(accountMessage);
       return id;
   }
}
