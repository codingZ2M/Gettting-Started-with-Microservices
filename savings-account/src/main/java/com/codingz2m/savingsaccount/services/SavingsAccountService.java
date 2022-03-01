package com.codingz2m.savingsaccount.services;

import java.util.List;
import java.util.UUID;

import com.codingz2m.savingsaccount.data.SavingsAccount;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionRequest;

public interface SavingsAccountService {
	
	SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO);
	 
	List<SavingsAccount> getSavingsAccounts();
	
	SavingsAccount findAccountById(UUID id);
	
	int savingsAccountTransaction(PaymentTransactionRequest savingsAccountTransactionRequest);
	
	boolean mutualFundTransaction(UUID savingsAccountId, double mutualFundAmonunt);
	
	
}
