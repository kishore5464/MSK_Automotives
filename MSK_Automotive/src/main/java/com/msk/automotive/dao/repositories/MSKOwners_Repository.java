package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.MSK_Owner;

@Repository
public interface MSKOwners_Repository extends JpaRepository<MSK_Owner, Integer> {

}
