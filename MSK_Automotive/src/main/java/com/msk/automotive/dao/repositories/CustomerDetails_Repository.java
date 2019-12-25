package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Customer_Details;

@Repository
public interface CustomerDetails_Repository extends JpaRepository<Customer_Details, Integer> {

}
