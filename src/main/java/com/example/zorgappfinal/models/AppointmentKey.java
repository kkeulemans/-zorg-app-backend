package com.example.zorgappfinal.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppointmentKey implements Serializable {

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "appointment_id")
    private Long appointmentId;

    public AppointmentKey() {}
    public AppointmentKey(Long appointmentId, Long accountId) {
        this.appointmentId= appointmentId;
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAccountId(Long accountId) {
        this.accountId= accountId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId= appointmentId;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        AppointmentKey that = (AppointmentKey) o;
        return appointmentId.equals(that.appointmentId)&& accountId.equals(that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId, accountId);
    }
}

