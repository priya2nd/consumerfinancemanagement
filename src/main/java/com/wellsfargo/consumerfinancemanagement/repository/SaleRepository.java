package com.wellsfargo.consumerfinancemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wellsfargo.consumerfinancemanagement.model.Sale;
import com.wellsfargo.consumerfinancemanagement.model.User;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query(value = "SELECT * FROM sale s WHERE s.user_name = ?1", nativeQuery = true)
	List<Sale> getProductListByUsername(String userName);

}