package com.codingz2m.mutualfund.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="mutual_fund")
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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getFundType() {
		return fundType;
	}

	public void setFundType(String fundType) {
		this.fundType = fundType;
	}

	public float getNav() {
		return nav;
	}

	public void setNav(float nav) {
		this.nav = nav;
	}

	public double getInvestedValue() {
		return investedValue;
	}

	public void setInvestedValue(double investedValue) {
		this.investedValue = investedValue;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public long getTotalUnits() {
		return totalUnits;
	}

	public void setTottalUnits(long totalUnits) {
		this.totalUnits = totalUnits;
	}

	public long getFreeUnits() {
		return freeUnits;
	}

	public void setFreeUnits(long freeUnits) {
		this.freeUnits = freeUnits;
	}

	public long getLockedUnits() {
		return lockedUnits;
	}

	public void setLockedUnits(long lockedUnits) {
		this.lockedUnits = lockedUnits;
	}

	public String getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(String investmentDate) {
		this.investmentDate = investmentDate;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}

	public MutualFundPortfolio getMutualFundPortfolio() {
		return mutualFundPortfolio;
	}

	public void setMutualFundPortfolio(MutualFundPortfolio mutualFundPortfolio) {
		this.mutualFundPortfolio = mutualFundPortfolio;
	}

	public UUID getSavingsAccountId() {
		return savingsAccountId;
	}

	public void setSavingsAccountId(UUID savingsAccountId) {
		this.savingsAccountId = savingsAccountId;
	}

	public String getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	public String getDebitOrCredit() {
		return debitOrCredit;
	}

	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}

}

