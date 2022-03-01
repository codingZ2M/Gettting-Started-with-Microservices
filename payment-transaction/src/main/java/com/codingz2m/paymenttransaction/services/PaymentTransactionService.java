package com.codingz2m.paymenttransaction.services;

import java.util.List;
import java.util.UUID;

import com.codingz2m.paymenttransaction.data.PaymentTransaction;
import com.codingz2m.paymenttransaction.shared.PaymentTransactionDTO;

public interface PaymentTransactionService {
	
	PaymentTransaction paymentTransaction(PaymentTransactionDTO paymentTransactionDTO);
	
	List<PaymentTransaction> getPaymentTransactions(UUID savimgsAccountId);
	
}
