package com.codingz2m.savingsaccount.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.savingsaccount.data.SavingsAccount;
import com.codingz2m.savingsaccount.data.SavingsAccountRepository;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionRequest;

@Service(value="savingsAccount")
@Transactional 
public class SavingsAccountServiceImpl implements SavingsAccountService {

	SavingsAccountRepository  savingsAccountRepository;
	
	@Autowired
	public SavingsAccountServiceImpl(SavingsAccountRepository savingsAccountRepository) {
		super();
		this.savingsAccountRepository = savingsAccountRepository;
	}

	@Override
	public SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO) {
		 ModelMapper modelMapper = new ModelMapper(); 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		  SavingsAccount savingsAccount = modelMapper.map(savingsAccountDTO, SavingsAccount.class);
		  savingsAccount = savingsAccountRepository.save(savingsAccount);
		  
		return savingsAccount;
	}

	
	@Override
	public List<SavingsAccount> getSavingsAccounts() {
		List <SavingsAccount> savingsAccountList   = new ArrayList<>();
		savingsAccountList = (List<SavingsAccount>) savingsAccountRepository.findAll();
		return savingsAccountList;
	}
	
	
	@Override
	public SavingsAccount findAccountById(UUID id) {
		Optional<SavingsAccount> savingsAccount = savingsAccountRepository.findById(id);
		return savingsAccount.get();
	}

	
	@Override
	public boolean mutualFundTransaction(UUID savingsAccountId, double mutualFundAmonunt) {
		boolean fundTransactionState;
		double totalCurrentValue = savingsAccountRepository.getSavingsAccountCurrentValue(savingsAccountId);
		System.out.println(totalCurrentValue);
		if (totalCurrentValue > mutualFundAmonunt) {
			totalCurrentValue -= mutualFundAmonunt;
			fundTransactionState = true;
		  }
		else {
			fundTransactionState = false;
		 }		
		savingsAccountRepository.updateSavingsAccount(savingsAccountId, totalCurrentValue);
		return fundTransactionState;
	}

	@Override
	public int savingsAccountTransaction(PaymentTransactionRequest savingsAccountTransactionRequest) {
		
		UUID savingsAccountId = savingsAccountTransactionRequest.getSavingsAccountId();
			double totalCurrentValue = savingsAccountRepository.getSavingsAccountCurrentValue(savingsAccountId);
			double amountToBeDeposited =  savingsAccountTransactionRequest.getAmount();
			String transactionType = savingsAccountTransactionRequest.getDebitOrCredit();
			if (transactionType.equals("Credit"))
				totalCurrentValue += amountToBeDeposited;
			else
				totalCurrentValue -= amountToBeDeposited;   
		 int transactionCount = savingsAccountRepository.updateSavingsAccount(savingsAccountId, totalCurrentValue);
	
		 return transactionCount;
	}


}