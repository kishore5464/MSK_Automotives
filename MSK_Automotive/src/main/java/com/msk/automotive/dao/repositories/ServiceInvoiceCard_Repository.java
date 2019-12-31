package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.ServiceInvoiceCard;

@Repository
public interface ServiceInvoiceCard_Repository extends JpaRepository<ServiceInvoiceCard, Integer> {

	@Query(value = "SELECT invoice FROM Service_Invoice_Card invoice WHERE invoice.customer_details_id = :customer_id")
	List<ServiceInvoiceCard> findByCustomer_Details(Integer customer_id);

}
