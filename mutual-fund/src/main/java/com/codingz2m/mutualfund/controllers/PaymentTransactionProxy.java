package com.codingz2m.mutualfund.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import com.codingz2m.mutualfund.ui.models.PaymentTransactionRequest;


// ****** MAKING REST CALLS USING FEIGN CLIENT **********

@FeignClient("PAYMENT-TRANSACTION")
public interface PaymentTransactionProxy {

	@PostMapping("/payment-transaction")
	public void initiatePaymentTransaction(PaymentTransactionRequest paymentTransactionRequest);
}