package com.codingz2m.mutualfund.controllers;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

// ****** MAKING REST CALLS USING FEIGN CLIENT **********

@FeignClient("SAVINGSACCOUNT")
public interface SavingsAccountProxy {

	@PostMapping("/savings-account/{savings-account-id}/{mutual-fund-amonunt}/mutual-fund")
	public boolean initiateMutualFundTransaction(
			@PathVariable(value="savings-account-id")UUID savingsAccountId, 
			@PathVariable(value="mutual-fund-amonunt") double mutualFundAmonunt);
}