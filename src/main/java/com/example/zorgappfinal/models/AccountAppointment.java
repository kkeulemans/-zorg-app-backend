package com.example.zorgappfinal.models;

import javax.persistence.*;

@Entity
public class AccountAppointment {

    @EmbeddedId
    AppointmentKey id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;


    public AppointmentKey getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setId(AppointmentKey id) {
        this.id = id;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAppointment(Appointment  appointment) {
        this.appointment = appointment;
    }
}
