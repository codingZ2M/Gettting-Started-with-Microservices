package com.codingz2m.savingsaccount.ui.models;

import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class SavingsAccountRequest {

	@Null
	private UUID id;
	@NotNull(message="Holder Name Cannot Be Null")
	private String holderName;
	@NotNull(message="Account Type Cannot Be Null")
	private String accountType;
	@NotNull(message="Annual Percentage Yield Cannot Be Null")
	private double annualPercentageYield; 
	@NotNull(message="Minimum Balance To Avail APY Cannot Be Null")
	private double minimumBalanceToAvailAPY;
	@NotNull(message="Minimum Balance To Open Account Cannot Be Null")
	private double minimumBalanceToOpenAccount;
	@NotNull(message="Current Value Cannot Be Null")
	@Min(value = 0, message="Current Value must be greater than or equal to 0 ")
	private double currentValue;
	
	
	public SavingsAccountRequest(@NotNull double annualPercentageYield, @NotNull double minimumBalanceToAvailAPY,
			@NotNull double minimumBalanceToOpenAccount) {
		super();
		this.annualPercentageYield = 0.16;
		this.minimumBalanceToAvailAPY = 200.00;
		this.minimumBalanceToOpenAccount = 100.00;
	}
	
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