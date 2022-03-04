package com.codingz2m.savingsaccount.shared;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingsAccountDTO {

	private UUID id;
	private String holderName;
	private String accountType;
	
	private double annualPercentageYield; 
	private double minimumBalanceToAvailAPY;
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	
	
}
