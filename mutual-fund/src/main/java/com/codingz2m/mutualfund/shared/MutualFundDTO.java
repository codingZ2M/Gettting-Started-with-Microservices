package com.codingz2m.mutualfund.shared;

import java.util.UUID;
import com.codingz2m.mutualfund.data.MutualFundPortfolio;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

	
	
}
