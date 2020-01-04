package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.CustomerDetails;

@Repository
public interface CustomerDetails_Repository extends JpaRepository<CustomerDetails, Integer> {

	public List<CustomerDetails> findByCarModels(Integer carModelsId);

	public List<CustomerDetails> findByRegistrationNo(String registrationNo);

}
