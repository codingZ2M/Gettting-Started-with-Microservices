package com.codingz2m.savingsaccount.config;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix = "savingsaccount")
@Getter @Setter @ToString
public class SavingsAccountServiceConfig {
	
	 private String message;
	 private String mail;
	 private String contact;
	 private List<String> types;
	 
	 @Bean
	 public ModelMapper getModelMapper() {
		return new ModelMapper(); 
	 }
}
