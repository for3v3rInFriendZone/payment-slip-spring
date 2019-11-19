package com.payment.slip.controller;

import com.payment.slip.model.PaymentSlip;
import com.payment.slip.service.PaymentSlipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/payment-slip")
@Slf4j
@RequiredArgsConstructor
public class PaymentSlipController {

  private final PaymentSlipService paymentSlipService;

  @GetMapping
  public List<PaymentSlip> getAllPaymentSlips() {
    return this.paymentSlipService.getAllPaymentSlips();
  }
}
