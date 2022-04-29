package com.example.zorgappfinal.repositories;

import com.example.zorgappfinal.models.MessageKey;
import com.example.zorgappfinal.models.AccountMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountMessageRepository extends JpaRepository<AccountMessage, MessageKey> {

    List<AccountMessage> findAllByAccountId(Long accountId );
    List<AccountMessage> findAllByMessageId(Long messageId);
}
