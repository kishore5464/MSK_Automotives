package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Service_Invoice_Card;

@Repository
public interface InvoiceCard_Repository extends JpaRepository<Service_Invoice_Card, Integer> {

}
