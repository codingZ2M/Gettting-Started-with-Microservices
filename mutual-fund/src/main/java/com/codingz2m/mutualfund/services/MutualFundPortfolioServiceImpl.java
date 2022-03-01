package com.codingz2m.mutualfund.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.mutualfund.data.MutualFund;
import com.codingz2m.mutualfund.data.MutualFundPortfolio;
import com.codingz2m.mutualfund.data.MutualFundPortfolioRepository;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.shared.MutualFundPortfolioDTO;

import java.util.Optional;

@Service (value="mutualFundPortfolio")
@Transactional 
public class MutualFundPortfolioServiceImpl implements MutualFundService {
	
	MutualFundPortfolioRepository  mutualFundPortfolioRepository;
	
	@Autowired
	public MutualFundPortfolioServiceImpl(MutualFundPortfolioRepository mutualFundPortfolioRepository) {
		super();
		this.mutualFundPortfolioRepository = mutualFundPortfolioRepository;
	}

	@Override
	public MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO) {
		 ModelMapper modelMapper = new ModelMapper(); 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		   MutualFundPortfolio mutualFundPortfolio = modelMapper.map(mutualFundPortfolioDTO, MutualFundPortfolio.class);
		   mutualFundPortfolio =   mutualFundPortfolioRepository.save(mutualFundPortfolio);
		       
		return mutualFundPortfolio;
	}

	@Override
	public List<MutualFund> getMutualFundsOfPortfolio(UUID mutualFundPortfolioId) {
	List <MutualFund> mutualFundList = new ArrayList<>();
		
		Optional<MutualFundPortfolio> mutualFundPortfolioOptional = mutualFundPortfolioRepository.findById(mutualFundPortfolioId);
		MutualFundPortfolio mutualFundPortfolioObject = mutualFundPortfolioOptional.get();
			mutualFundList =	mutualFundPortfolioObject.retrieveMutualFunds();
		return mutualFundList;
	}
	
	
	@Override
	public MutualFund createMutualFund(MutualFundDTO mutualFundDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	

	


}
