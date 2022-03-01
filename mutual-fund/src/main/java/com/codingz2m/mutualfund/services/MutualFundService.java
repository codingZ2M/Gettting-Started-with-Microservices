package com.codingz2m.mutualfund.services;

import java.util.List;
import java.util.UUID;

import com.codingz2m.mutualfund.data.MutualFund;
import com.codingz2m.mutualfund.data.MutualFundPortfolio;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.shared.MutualFundPortfolioDTO;

public interface MutualFundService {
	
	MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO);
	
	MutualFund createMutualFund(MutualFundDTO mutualFundDTO);
	
	List<MutualFund> getMutualFundsOfPortfolio(UUID mutualFundPortfolioId);
}
