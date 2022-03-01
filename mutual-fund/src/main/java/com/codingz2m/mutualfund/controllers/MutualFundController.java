package com.codingz2m.mutualfund.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.mutualfund.config.MutualFundServiceConfig;
import com.codingz2m.mutualfund.data.CustomerServiceInfo;
import com.codingz2m.mutualfund.data.MutualFund;
import com.codingz2m.mutualfund.services.MutualFundService;
import com.codingz2m.mutualfund.shared.MutualFundDTO;
import com.codingz2m.mutualfund.ui.models.MutualFundRequest;
import com.codingz2m.mutualfund.ui.models.MutualFundResponse;
import com.codingz2m.mutualfund.ui.models.PaymentTransactionRequest;

import feign.FeignException.FeignServerException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/mutual-fund")
public class MutualFundController {
	
	@Autowired
	private MutualFundServiceConfig mutualFundServiceConfig;
	@Autowired
	private CustomerServiceInfo customerServiceInfo;
	
	private MutualFundService mutualFundService;
	private SavingsAccountProxy savingsAccountProxy;
	private PaymentTransactionProxy paymentTransactionProxy;
	
	@Autowired	
	public MutualFundController(@Qualifier("mutualFundService") MutualFundService mutualFundService,
			SavingsAccountProxy savingsAccountProxy,
			PaymentTransactionProxy paymentTransactionProxy) {
		super();
		this.mutualFundService = mutualFundService;
		this.savingsAccountProxy = savingsAccountProxy;
		this.paymentTransactionProxy = paymentTransactionProxy;
	}
	

	@GetMapping("/customer-service")
	public CustomerServiceInfo getPropertyDetails() {
		customerServiceInfo.setMessage(mutualFundServiceConfig.getMessage());
		customerServiceInfo.setContact(mutualFundServiceConfig.getContact());
		customerServiceInfo.setMail(mutualFundServiceConfig.getMail());
		customerServiceInfo.setTypes(mutualFundServiceConfig.getTypes());
		return customerServiceInfo;
	}
	
	// HTTP POST with SpringMVC
	@PostMapping
	@CircuitBreaker(name = "mutualFundProcessState", fallbackMethod
							="mutualFundProcessStateFallBack")
	public ResponseEntity<MutualFundResponse> createMutualFund( 
			@Valid @RequestBody MutualFundRequest mutualFundRequest ) {
		MutualFund mutualFund=null;
		ModelMapper modelMapper=null;
		MutualFundResponse mutualFundResponse = null;
		MutualFundDTO mutualFundDTO = null;
		boolean fundTransactionState=false;
				
		 try {
		 fundTransactionState = savingsAccountProxy.initiateMutualFundTransaction(
				mutualFundRequest.getSavingsAccountId(),mutualFundRequest.getInvestedValue());
		 	modelMapper = new ModelMapper(); 	
			modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			mutualFundDTO = modelMapper.map( mutualFundRequest, MutualFundDTO.class); 
			
		 if (fundTransactionState) {									
				mutualFund  = mutualFundService.createMutualFund(mutualFundDTO);
				mutualFundResponse = modelMapper.map(mutualFund, MutualFundResponse.class);
				
				PaymentTransactionRequest paymentTransactionRequest = new PaymentTransactionRequest();
				paymentTransactionRequest.setTransactionDate(mutualFundRequest.getInvestmentDate());
				paymentTransactionRequest.setTransactionDetails(mutualFundRequest.getTransactionDetails());
				paymentTransactionRequest.setAmount(mutualFundRequest.getInvestedValue());
				paymentTransactionRequest.setDebitOrCredit(mutualFundRequest.getDebitOrCredit());
				paymentTransactionRequest.setSavingsAccountId(mutualFundRequest.getSavingsAccountId() );
				
				paymentTransactionProxy.initiatePaymentTransaction(paymentTransactionRequest);
			}
		 else {
			 
			 mutualFundResponse = new MutualFundResponse();
			 mutualFundResponse.setFundTransactionState("INSUFFICIENT FUND IN YOUR SAVINGS ACCOUNT: " 
						+ mutualFundRequest.getSavingsAccountId());
		 }
	    } catch(org.springframework.aop.AopInvocationException aie)	{
			//	mutualFundResponse.setFundTransactionState("INSUFFICIENT FUND IN YOUR SAVINGS ACCOUNT: " 
			//			+ mutualFundRequest.getSavingsAccountId());
				//return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
			}
		 catch (FeignServerException fe){
			// mutualFundResponse.setFundTransactionState("INSUFFICIENT FUND IN YOUR SAVINGS ACCOUNT: " 
			//			+ mutualFundRequest.getSavingsAccountId());
			// return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
		 }
		 catch (NullPointerException ne){
			// mutualFundResponse.setFundTransactionState("INSUFFICIENT FUND IN YOUR SAVINGS ACCOUNT: " 
				//		+ mutualFundRequest.getSavingsAccountId());
			 //return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
		 }
	
		 return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
  }
	
	

	private ResponseEntity<MutualFundResponse>mutualFundProcessStateFallBack(MutualFundRequest mutualFundRequest, Throwable t) {
		 ModelMapper modelMapper = new ModelMapper();
		MutualFundResponse mutualFundResponse = modelMapper.map(mutualFundRequest, MutualFundResponse.class);
		 return ResponseEntity.status(HttpStatus.CREATED).body(mutualFundResponse);
	}
	

}

