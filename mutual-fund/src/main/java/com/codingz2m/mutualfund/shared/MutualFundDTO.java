package com.codingz2m.mutualfund.shared;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.codingz2m.mutualfund.data.MutualFundPortfolio;

public class MutualFundDTO {

	private UUID id;
	private String fundName;
	private String schemeType;
	private String fundType;
	private float nav;
	private double investedValue;
	private double currentValue;
	private long totalUnits;
	private long freeUnits;
	private long lockedUnits;
	private String investmentDate;
	private String investmentType;
	private String transactionDetails;
	private String debitOrCredit;
	private UUID savingsAccountId;
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

	public void setTotalUnits(long totalUnits) {
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
