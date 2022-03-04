package com.codingz2m.savingsaccount.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingz2m.savingsaccount.ui.models.PaymentTransactionRequest;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionResponse;

import java.util.List;
import java.util.UUID;

// ****** MAKING REST CALLS USING FEIGN CLIENT **********

//@FeignClient(name = "payment-transaction", url = "${PAYMENT_TRANSACTION_SERVICE_HOST:http://localhost}:8082")
@FeignClient("PAYMENT-TRANSACTION")
public interface PaymentTransactionProxy {

	@PostMapping("/payment-transaction")
	public void initiatePaymentTransaction(PaymentTransactionRequest paymentTransactionRequest );
	
	
	@GetMapping("/payment-transaction/{savings-account-id}")
	public List<PaymentTransactionResponse> getPaymentTransactions(
    		@PathVariable(value="savings-account-id") UUID savingsAccountId);
	
}

