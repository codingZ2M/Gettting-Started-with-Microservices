package com.codingz2m.mutualfund;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RefreshScope
public class MutualFundApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutualFundApplication.class, args);
	}

}
