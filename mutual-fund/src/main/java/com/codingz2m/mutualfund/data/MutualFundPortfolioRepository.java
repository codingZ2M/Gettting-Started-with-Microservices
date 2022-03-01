package com.codingz2m.mutualfund.data;


import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MutualFundPortfolioRepository extends CrudRepository<MutualFundPortfolio, UUID> {

	// Using Spring Data JPA @Query
	// Custom Queries with @Query Annotation
	// Creating JPA-based repository layer, using Spring Data JPA
	
	 // JPQL Update @Query
    @Modifying
	@Query("UPDATE MutualFundPortfolio mfp SET mfp.totalInvestedValue = :totalInvestedValue WHERE "
	 		                           + "mfp.id = :id")
    int updateMutualFundPortfolio(@Param("id") UUID id, @Param("totalInvestedValue") double totalInvestedValue);
	
    @Query("SELECT totalInvestedValue FROM MutualFundPortfolio mfp WHERE mfp.id = :id")
    double getPortfolioTotalInvestedValue(@Param("id") UUID id);
    

}
