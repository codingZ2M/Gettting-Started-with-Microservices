package com.codingz2m.paymenttransaction.shared;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class PaymentTransactionDTO {
	
	private UUID id;
	private String transactionDate;
	private String transactionDetails;
	
	private double amount;
	private String debitOrCredit;
	private UUID savingsAccountId;
	
	
	
}
