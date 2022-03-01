package com.codingz2m.mutualfund.ui.models;

import java.util.List;
import java.util.UUID;

import com.codingz2m.mutualfund.data.MutualFund;

public class MutualFundPortfolioResponse {

	private UUID id;
	private String holderName;
	private double totalInvestedValue;
	private double totalCurrentValue;
	private double gainOrLoss; 
	private List<MutualFund> mutualFunds;
	
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
	public double getTotalInvestedValue() {
		return totalInvestedValue;
	}
	public void setTotalInvestedValue(double totalInvestedValue) {
		this.totalInvestedValue = totalInvestedValue;
	}
	public double getTotalCurrentValue() {
		return totalCurrentValue;
	}
	public void setTotalCurrentValue(double totalCurrentValue) {
		this.totalCurrentValue = totalCurrentValue;
	}
	public double getGainOrLoss() {
		return gainOrLoss;
	}
	public void setGainOrLoss(double gainOrLoss) {
		this.gainOrLoss = gainOrLoss;
	}
	public List<MutualFund> getMutualFunds() {
		return mutualFunds;
	}
	public void setMutualFunds(List<MutualFund> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}
	
}
