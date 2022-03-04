package com.codingz2m.mutualfund.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name="mutual_fund")
@Getter @Setter
public class MutualFund {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=120)
	private String fundName;
	@Column(nullable=false, length=20)
	private String schemeType;
	
	@Column(nullable=false, length=30)
	private String fundType;
	@Column(nullable=false, length=10)
	private float nav;
	@Column(nullable=false, length=20)
	private double investedValue;
	
	@Column(nullable=false, length=20)
	private double currentValue;
	@Column(nullable=false, length=20)
	private long totalUnits;
	@Column(nullable=false, length=20)
	private long freeUnits;
	
	@Column(nullable=false, length=20)
	private long lockedUnits;
	@Column(nullable=false, length=60)
	private String investmentDate;
	@Column(nullable=false, length=15)
	private String investmentType;

	@Column(nullable=false, length=200)
	private String transactionDetails;
	@Column(nullable=false, length=10)
	private String debitOrCredit;
	@Column(nullable=false, length=50)
	private UUID savingsAccountId;
	
	@ManyToOne 
	@JoinColumn(name="mutual_fund_portfolio_id")
	private MutualFundPortfolio mutualFundPortfolio;

	
}

