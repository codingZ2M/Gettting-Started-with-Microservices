package com.codingz2m.paymenttransaction.ui.models;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentTransactionRequest {
	
	@Null
	private UUID id;
	@NotNull(message="Transaction Date Cannot Be Null")
	private String transactionDate;
	
	@NotNull(message="Transaction Details Cannot Be Null")
	private String transactionDetails;
	@NotNull(message="Amount Cannot Be Null")
	@Min(value = 0, message="Amount must be greater than or equal to 0 ")
	private double amount;
	
	@NotNull(message="Debit / Credit Value Cannot Be Null")
	private String debitOrCredit;
	@NotNull(message="Savings Account Id Cannot Be Null")
	private UUID savingsAccountId;
	
	
	
}
