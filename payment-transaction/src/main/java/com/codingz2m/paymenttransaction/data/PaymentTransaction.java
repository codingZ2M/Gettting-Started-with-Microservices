package com.codingz2m.paymenttransaction.data;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_transaction")
public class PaymentTransaction {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=60)
	private String transactionDate;
	@Column(nullable=false, length=200)
	private String transactionDetails;
	@Column(nullable=false, length=20)
	private double amount;
	@Column(nullable=false, length=10)
	private String debitOrCredit;
	@Column(nullable=false, length=50)
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
