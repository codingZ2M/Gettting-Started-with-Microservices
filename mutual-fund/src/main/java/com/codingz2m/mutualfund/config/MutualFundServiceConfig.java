package com.codingz2m.mutualfund.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties(prefix = "mutualfund")
@Getter @Setter @ToString
public class MutualFundServiceConfig {
	
	 private String message;
	 private String mail;
	 private String contact;
	 private List<String> types;
}
