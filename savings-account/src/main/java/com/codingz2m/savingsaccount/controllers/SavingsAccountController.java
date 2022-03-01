package com.codingz2m.savingsaccount.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.savingsaccount.config.SavingsAccountServiceConfig;
import com.codingz2m.savingsaccount.data.CustomerServiceInfo;
import com.codingz2m.savingsaccount.data.SavingsAccount;
import com.codingz2m.savingsaccount.services.SavingsAccountService;
import com.codingz2m.savingsaccount.shared.SavingsAccountDTO;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionResponse;
import com.codingz2m.savingsaccount.ui.models.SavingsAccountRequest;
import com.codingz2m.savingsaccount.ui.models.SavingsAccountResponse;
import com.codingz2m.savingsaccount.ui.models.PaymentTransactionRequest;

@RestController
@RequestMapping("/savings-account")
public class SavingsAccountController {

	@Autowired
	private SavingsAccountServiceConfig savingsAccountServiceConfig;
	@Autowired
	private CustomerServiceInfo customerServiceInfo;
	
	private SavingsAccountService savingsAccountService;
	private PaymentTransactionProxy paymentTransactionProxy;
	
	@Autowired	
	public SavingsAccountController(@Qualifier("savingsAccount") SavingsAccountService savingsAccountService,
			PaymentTransactionProxy paymentTransactionProxy) {
	
		this.savingsAccountService = savingsAccountService;
		this.paymentTransactionProxy = paymentTransactionProxy;
	}
	
	
	@GetMapping("/customer-service")
	public CustomerServiceInfo getPropertyDetails() {
		customerServiceInfo.setMessage(savingsAccountServiceConfig.getMessage());
		customerServiceInfo.setContact(savingsAccountServiceConfig.getContact());
		customerServiceInfo.setMail(savingsAccountServiceConfig.getMail());
		customerServiceInfo.setTypes(savingsAccountServiceConfig.getTypes());
		return customerServiceInfo;
	}
	
	// HTTP POST with SpringMVC
	@PostMapping
	public ResponseEntity<SavingsAccountResponse> createSavingsAccount( @Valid @RequestBody SavingsAccountRequest savingsAccountRequest) {

	ModelMapper modelMapper = new ModelMapper(); 	
	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

	SavingsAccountDTO savingsAccountDTO = modelMapper.map( savingsAccountRequest, SavingsAccountDTO.class); 		
	SavingsAccount savingsAccount  = savingsAccountService.createSavingsAccount(savingsAccountDTO);

	SavingsAccountResponse savingsAccountResponse = modelMapper.map(savingsAccount, SavingsAccountResponse.class);
	return ResponseEntity.status(HttpStatus.CREATED).body(savingsAccountResponse);
  }
	
	
	@GetMapping(path ="/all")
	public List<SavingsAccount> getAllSavingsAccount() {
		List <SavingsAccount> savingsAccountList   = new ArrayList<>();
		savingsAccountList = savingsAccountService.getSavingsAccounts();
		  return savingsAccountList;
	}
	
	
	
	@PostMapping("/getSavingsAccount")
	public SavingsAccount findSavingsAccount(@RequestBody SavingsAccountRequest savingsAccountRequest) {
		SavingsAccount savingsAccount = savingsAccountService.findAccountById(savingsAccountRequest.getId());
		if (savingsAccount != null) {
			return savingsAccount;
		} else {
			return null;
		}
	}
	
	
	// HTTP POST with SpringMVC
	@PostMapping( path="/payment-transaction")
	public void initiateSavingsAccountTransaction( @Valid @RequestBody PaymentTransactionRequest paymentTransactionRequest) {		 		
		
		int transactionCount = savingsAccountService.savingsAccountTransaction(paymentTransactionRequest);
        
		if(transactionCount == 1) {			
			paymentTransactionProxy.initiatePaymentTransaction(paymentTransactionRequest);
		} 
	  }
	
	
	
	
	@GetMapping(path ="/{savings-account-id}/payment-transactions")
	public List<PaymentTransactionResponse> getPaymentTransactions(
    		@PathVariable(value="savings-account-id") UUID savingsAccountId) {
		
		List <PaymentTransactionResponse> paymentTransactionResponseList   = new ArrayList<>();
		paymentTransactionResponseList = paymentTransactionProxy.getPaymentTransactions(savingsAccountId);
		  return paymentTransactionResponseList;
	}
	
	
	

	@PostMapping(path ="/{savings-account-id}/{mutual-fund-amonunt}/mutual-fund")
	public boolean initiateMutualFundTransaction(
			@PathVariable(value="savings-account-id")UUID savingsAccountId, 
			@PathVariable(value="mutual-fund-amonunt") double mutualFundAmonunt  ) {
	  boolean fundTransactionState;
	  fundTransactionState = savingsAccountService.mutualFundTransaction(savingsAccountId, mutualFundAmonunt);
	  return fundTransactionState;
	}

	
}
