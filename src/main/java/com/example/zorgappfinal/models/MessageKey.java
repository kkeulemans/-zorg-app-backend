package com.example.zorgappfinal.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MessageKey  implements Serializable {

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "message_id")
    private Long messageId;

    public MessageKey() {}
    public MessageKey(Long messageId, Long accountId) {
        this.messageId= messageId;
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getMessageId() {
        return messageId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setMessageId(Long messageId) {
        this.messageId= messageId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MessageKey that = (MessageKey) o;
        return messageId.equals(that.messageId)&& accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, accountId);
    }
}
