package com.codingz2m.paymenttransaction.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration

@Getter @Setter
public class PaymentTransactionConfig {
	 
	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
}