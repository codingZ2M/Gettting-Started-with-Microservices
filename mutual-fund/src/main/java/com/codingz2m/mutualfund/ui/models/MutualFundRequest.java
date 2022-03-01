package com.codingz2m.mutualfund.ui.models;

import javax.validation.constraints.Null;
import com.codingz2m.mutualfund.data.MutualFundPortfolio;
import java.util.UUID;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MutualFundRequest {
	@Null
	private UUID id;
	@NotNull(message="Fund Name Cannot Be Null")
	private String fundName;
	@NotNull(message="Scheme Type Cannot Be Null")
		private String schemeType;
		@NotNull(message="Fund Type Cannot Be Null")
		private String fundType;
	@NotNull(message="NAV Cannot Be Null")
	@Min(value = 0, message="NAV Value must be greater than or equal to 0 ")
	private float nav;
	@NotNull(message="Invested Value Cannot Be Null")
	@Min(value = 0, message="Invested Value must be greater than or equal to 0 ")
	private double investedValue;
	@NotNull(message="Current Value Cannot Be Null")
	@Min(value = 0, message="Current Value must be greater than or equal to 0 ")
	private double currentValue;
	@NotNull(message="tottalUnits Cannot Be Null")
	@Min(value = 0, message="Total Units must be greater than or equal to 0 ")
	private long totalUnits;
	@NotNull(message="Free Units Cannot Be Null")
	private long freeUnits;
	@NotNull(message="Locked Units Cannot Be Null")
	private long lockedUnits;
	@NotNull(message="Investment Date Cannot Be Null")
	private String investmentDate;
	@NotNull(message="Investment Type Cannot Be Null")
	private String investmentType;
	@NotNull(message="Transaction Details Cannot Be Null")
	private String transactionDetails;
	@NotNull(message="Debit/Credit Value Cannot Be Null")
	private String debitOrCredit;
	@NotNull(message="Savings Account Id Cannot Be Null")
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
