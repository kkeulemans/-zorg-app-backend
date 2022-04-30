package com.example.zorgappfinal.controller;

import com.example.zorgappfinal.dto.ImageDto;
import com.example.zorgappfinal.dto.MessageDto;
import com.example.zorgappfinal.models.Message;
import com.example.zorgappfinal.repositories.ImageRepository;
import com.example.zorgappfinal.repositories.MessageRepository;
import com.example.zorgappfinal.services.AccountMessageService;
import com.example.zorgappfinal.services.ImageService;
import com.example.zorgappfinal.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private AccountMessageService accountMessageService;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    ImageService imageService;
    @GetMapping("/messages")
    public ResponseEntity<List<MessageDto>> getAllMessages(){
        List<MessageDto> messageDtos = messageService.getAllMessages();
        return ResponseEntity.ok().body(messageDtos);
    }

    @GetMapping("/messages/{id}")
    public MessageDto getMessageById(@PathVariable("id") Long id){
        MessageDto dto = messageService.getMessageById(id);

        return dto;
    }

    @PostMapping("/messages/new")
    public MessageDto addMessage (@RequestBody MessageDto dto){
        MessageDto messageToBeAdded = messageService.addMessage(dto);
        return messageToBeAdded;
    }


    @PutMapping("/messages/{id}")
    public MessageDto updateMessage(@PathVariable("id") Long id, @RequestBody MessageDto dto){
        messageService.updateMessage(id,dto);
        return dto;
    }

    @PutMapping("/messages/{id}/users/{accountId}")
    public void assignToUser(@PathVariable("id") Long id, @PathVariable("accountId") Long accountId){
       accountMessageService.addUserMessage(id,accountId);
        messageService.assignToAccount(id, accountId);
    }

    @GetMapping("/{accountId}/messages")
    public ResponseEntity<List<MessageDto>> getMessagesByAccountId(@PathVariable("accountId") Long accountId){

        return ResponseEntity.ok().body(accountMessageService.getAllByAccountId(accountId));
    }

    @GetMapping("/messages/{id}/attachment")
    public ImageDto getAttachment (@PathVariable("id") Long id){
        Message message = messageRepository.getById(id);
        Long accountId = message.getAttachment().getId();

        return imageService.getImageById(accountId);
    }
}
