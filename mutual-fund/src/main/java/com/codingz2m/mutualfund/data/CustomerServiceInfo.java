package com.codingz2m.mutualfund.data;

import java.util.List;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter @Setter @ToString
public class CustomerServiceInfo {
	 private String message;
	 private String mail;
	 private String contact;
	 private List<String> types;
}
