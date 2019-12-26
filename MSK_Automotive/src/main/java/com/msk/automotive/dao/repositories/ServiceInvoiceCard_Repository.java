package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Service_Invoice_Card;

@Repository
public interface ServiceInvoiceCard_Repository extends JpaRepository<Service_Invoice_Card, Integer> {

	@Query(value = "SELECT invoice FROM Service_Invoice_Card invoice WHERE invoice.customer_details_id = :customer_id")
	List<Service_Invoice_Card> findByCustomer_Details(Integer customer_id);

}
