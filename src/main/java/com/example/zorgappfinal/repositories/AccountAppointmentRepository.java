package com.example.zorgappfinal.repositories;

import com.example.zorgappfinal.models.AppointmentKey;
import com.example.zorgappfinal.models.AccountAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountAppointmentRepository extends JpaRepository <AccountAppointment, AppointmentKey> {

    List<AccountAppointment> findAllByAccountId(Long accountId);
    List<AccountAppointment> findAllByAppointmentId(Long messageId);
}
