package com.codingz2m.savingsaccount.ui.models;

import java.util.UUID;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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
	
	
}