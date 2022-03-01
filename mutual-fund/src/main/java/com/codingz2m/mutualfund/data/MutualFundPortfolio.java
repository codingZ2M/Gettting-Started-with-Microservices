package com.codingz2m.mutualfund.data;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="mutual_fund_portfolio")
public class MutualFundPortfolio {
	
	@Id
	@GeneratedValue
	private UUID id;
	@Column(nullable=false, length=50)
	private String holderName;
	@Column(nullable=false, length=20)
	private double totalInvestedValue;
	@Column(nullable=false, length=20)
	private double totalCurrentValue;
	@Column(nullable=false, length=6)
	private double gainOrLoss; 
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="mutualFundPortfolio", 
			cascade=CascadeType.ALL, orphanRemoval = true)
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

	public List<MutualFund> retrieveMutualFunds() {
		return mutualFunds;
	}

	public void setMutualFunds(List<MutualFund> mutualFunds) {
		this.mutualFunds = mutualFunds;
	}
	 
}