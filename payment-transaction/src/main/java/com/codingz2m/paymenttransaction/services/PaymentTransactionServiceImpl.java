package com.codingz2m.paymenttransaction.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.paymenttransaction.data.PaymentTransaction;
import com.codingz2m.paymenttransaction.data.PaymentTransactionRepository;
import com.codingz2m.paymenttransaction.shared.PaymentTransactionDTO;

@Service(value="paymentTransaction")
@Transactional
public class PaymentTransactionServiceImpl implements PaymentTransactionService {

	PaymentTransactionRepository  paymentTransactionRepository;
	
	@Autowired
	public PaymentTransactionServiceImpl(PaymentTransactionRepository paymentTransactionRepository) {
		super();
		this.paymentTransactionRepository = paymentTransactionRepository;
	}


	@Override
	public PaymentTransaction paymentTransaction(PaymentTransactionDTO paymentTransactionDTO) {
		
		 ModelMapper modelMapper = new ModelMapper(); 
		  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		  PaymentTransaction paymentTransaction = modelMapper.map(paymentTransactionDTO, PaymentTransaction.class);
		  paymentTransaction = paymentTransactionRepository.save(paymentTransaction);
	
		return paymentTransaction;
	}


	@Override
	public List<PaymentTransaction> getPaymentTransactions(UUID savingsAccountId) {
		
		List <PaymentTransaction> paymentTransactionList = new ArrayList<>();
		paymentTransactionList = paymentTransactionRepository.getPaymentTransactions(savingsAccountId);
		return paymentTransactionList;
	}

}
