package com.example.zorgappfinal.services;

import com.example.zorgappfinal.dto.MessageDto;
import com.example.zorgappfinal.models.MessageKey;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountMessageService {

    List<MessageDto> getAllByAccountId(Long accountId);
    MessageKey addUserMessage (Long messageId, Long accountId);
}
