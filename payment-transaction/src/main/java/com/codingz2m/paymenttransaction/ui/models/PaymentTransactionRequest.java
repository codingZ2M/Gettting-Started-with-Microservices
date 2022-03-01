package com.codingz2m.paymenttransaction.ui.models;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;


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
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDebitOrCredit() {
		return debitOrCredit;
	}
	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}
	public UUID getSavingsAccountId() {
		return savingsAccountId;
	}
	public void setSavingsAccountId(UUID savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}
	
}
