package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Customer_Contact_Details;

@Repository
public interface CustomerContactDetails_Repository extends JpaRepository<Customer_Contact_Details, Integer> {

}
