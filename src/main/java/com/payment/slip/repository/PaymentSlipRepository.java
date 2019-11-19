package com.payment.slip.repository;

import com.payment.slip.model.PaymentSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSlipRepository extends JpaRepository<PaymentSlip, Long> {
}
