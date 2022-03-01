package com.codingz2m.mutualfund.ui.models;

import java.util.UUID;

public class PaymentTransactionRequest {
	
	private String transactionDate;
	private String transactionDetails;
	private double amount;
	private String debitOrCredit;
	private UUID savingsAccountId;
	 
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