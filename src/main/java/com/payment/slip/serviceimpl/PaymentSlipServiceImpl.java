package com.payment.slip.serviceimpl;

import com.payment.slip.model.PaymentSlip;
import com.payment.slip.repository.PaymentSlipRepository;
import com.payment.slip.service.PaymentSlipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentSlipServiceImpl implements PaymentSlipService {

  private final PaymentSlipRepository paymentSlipRepository;

  @Override
  public List<PaymentSlip> getAllPaymentSlips() {
    return this.paymentSlipRepository.findAll();
  }
}
