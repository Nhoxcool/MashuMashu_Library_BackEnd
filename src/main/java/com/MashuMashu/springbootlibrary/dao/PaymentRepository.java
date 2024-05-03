package com.MashuMashu.springbootlibrary.dao;

import com.MashuMashu.springbootlibrary.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByUserEmail(String userEmail);
}