package com.codingz2m.savingsaccount.data;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="savings_account")
@Getter @Setter
public class SavingsAccount {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=120)
	private String holderName;
	
	@Column(nullable=false, length=120)
	private String accountType;
	@Column(nullable=false, length=5)
	private double annualPercentageYield;
	@Column(nullable=false, length=10)
	private double minimumBalanceToAvailAPY;
	
	@Column(nullable=false, length=10)
	private double minimumBalanceToOpenAccount;
	@Column(nullable=false, length=20)
	private double currentValue;
	
	
	
}