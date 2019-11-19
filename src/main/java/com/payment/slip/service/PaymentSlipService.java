package com.payment.slip.service;

import com.payment.slip.model.PaymentSlip;

import java.util.List;

public interface PaymentSlipService {

  List<PaymentSlip> getAllPaymentSlips();
}
