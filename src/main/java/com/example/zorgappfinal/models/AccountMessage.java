package com.example.zorgappfinal.models;

import javax.persistence.*;

@Entity
public class AccountMessage {
    @EmbeddedId
    MessageKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId("messageId")
    @JoinColumn(name = "message_id")
    private Message message;


    public MessageKey getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Message getMessage() {
        return message;
    }

    public void setId(MessageKey id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setMessage(Message  message) {
        this.message = message;
    }
}
