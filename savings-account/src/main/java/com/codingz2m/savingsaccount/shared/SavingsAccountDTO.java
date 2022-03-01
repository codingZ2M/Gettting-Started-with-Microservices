package com.codingz2m.savingsaccount.shared;

import java.util.UUID;

public class SavingsAccountDTO {

	private UUID id;
	private String holderName;
	private String accountType;
	private double annualPercentageYield; 
	private double minimumBalanceToAvailAPY;
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	public double getAnnualPercentageYield() {
		return annualPercentageYield;
	}
	public void setAnnualPercentageYield(double annualPercentageYield) {
		this.annualPercentageYield = annualPercentageYield;
	}
	public double getMinimumBalanceToAvailAPY() {
		return minimumBalanceToAvailAPY;
	}
	public void setMinimumBalanceToAvailAPY(double minimumBalanceToAvailAPY) {
		this.minimumBalanceToAvailAPY = minimumBalanceToAvailAPY;
	}
	public double getMinimumBalanceToOpenAccount() {
		return minimumBalanceToOpenAccount;
	}
	public void setMinimumBalanceToOpenAccount(double minimumBalanceToOpenAccount) {
		this.minimumBalanceToOpenAccount = minimumBalanceToOpenAccount;
	}
	
	
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
}
