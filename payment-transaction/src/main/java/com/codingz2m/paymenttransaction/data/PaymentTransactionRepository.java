package com.codingz2m.paymenttransaction.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PaymentTransactionRepository  extends CrudRepository<PaymentTransaction, UUID> {
	
	@Query("SELECT pt FROM PaymentTransaction pt WHERE pt.savingsAccountId = :savingsAccountId")
    List <PaymentTransaction> getPaymentTransactions(@Param("savingsAccountId") UUID savingsAccountId);
}
