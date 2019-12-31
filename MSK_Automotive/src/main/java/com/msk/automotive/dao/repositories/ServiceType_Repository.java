package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.ServiceType;

@Repository
public interface ServiceType_Repository extends JpaRepository<ServiceType, Integer> {

}
