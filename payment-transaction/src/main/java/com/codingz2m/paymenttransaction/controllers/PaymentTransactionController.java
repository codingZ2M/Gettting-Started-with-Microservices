package com.codingz2m.paymenttransaction.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.paymenttransaction.data.PaymentTransaction;
import com.codingz2m.paymenttransaction.services.PaymentTransactionService;
import com.codingz2m.paymenttransaction.shared.PaymentTransactionDTO;
import com.codingz2m.paymenttransaction.ui.models.PaymentTransactionRequest;
import com.codingz2m.paymenttransaction.ui.models.PaymentTransactionResponse;


@RestController
@RequestMapping("/payment-transaction")
public class PaymentTransactionController {

	private static final Logger logger = LoggerFactory.getLogger(PaymentTransactionController.class);
	
	private PaymentTransactionService paymentTransactionService;
	@Autowired	
	ModelMapper modelMapper;
	
	@Autowired	
	public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
		this.paymentTransactionService = paymentTransactionService;
	}
	
	@PostMapping
	public void initiatePaymentTransaction( @RequestBody PaymentTransactionRequest paymentTransactionRequest
			) {
		logger.info("initiatePaymentTransaction() method in payment-transaction service started");
		PaymentTransactionDTO paymentTransactionDTO = new PaymentTransactionDTO();
		paymentTransactionDTO.setTransactionDate(paymentTransactionRequest.getTransactionDate());
		paymentTransactionDTO.setTransactionDetails(paymentTransactionRequest.getTransactionDetails());
		paymentTransactionDTO.setAmount(paymentTransactionRequest.getAmount());
		paymentTransactionDTO.setDebitOrCredit(paymentTransactionRequest.getDebitOrCredit());
		paymentTransactionDTO.setSavingsAccountId(paymentTransactionRequest.getSavingsAccountId());
		
	    paymentTransactionService.paymentTransaction(paymentTransactionDTO);
	    logger.info("initiatePaymentTransaction() method in payment-transaction service ended");
	}
	
	
	// HTTP GET with Spring MVC
    // One-To-Many Mapping (BI-Directional: From  MutualFundPortfolio To List <MutualFund> Object)
	  @GetMapping(path ="/{savings-account-id}")
	    public List<PaymentTransactionResponse > getPaymentTransactions(
	    		@PathVariable(value="savings-account-id") UUID savingsAccountId){
		  
		  List <PaymentTransaction> paymentTransactionList   = new ArrayList<>();
		  List <PaymentTransactionResponse> paymentTransactionResponseList   = new ArrayList<>();
		  
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			
			paymentTransactionList = paymentTransactionService.getPaymentTransactions(savingsAccountId);
			  
			 paymentTransactionResponseList = Arrays.asList( modelMapper.map(paymentTransactionList, PaymentTransactionResponse[].class));
			return  paymentTransactionResponseList;
			
	    }
}
