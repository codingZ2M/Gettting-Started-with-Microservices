package com.codingz2m.mutualfund.ui.models;

import java.util.UUID;
import javax.validation.constraints.Null;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class MutualFundPortfolioRequest {
	
	@Null
	private UUID id;
	@NotNull(message="Holder Name Cannot Be Null")
	private String holderName;
	@NotNull(message="Total Invested Value Cannot Be Null")
	@Min(value = 0, message="Total Invested Value must be greater than or equal to 0 ")
	private double totalInvestedValue;
	@NotNull(message="Total Current Value Cannot Be Null")
	@Min(value = 0, message="Total Current Value must be greater than or equal to 0 ")
	private double totalCurrentValue;
	@NotNull(message="Gain or Loss Cannot Be Null")
	private double gainOrLoss;
	
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
	
}

