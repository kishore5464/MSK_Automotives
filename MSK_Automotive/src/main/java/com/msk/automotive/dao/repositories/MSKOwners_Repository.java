package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.MSKOwner;

@Repository
public interface MSKOwners_Repository extends JpaRepository<MSKOwner, Integer> {

	public List<MSKOwner> findByEmail(String email);

}
