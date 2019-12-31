package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.ServiceAdvisor;

@Repository
public interface ServiceAdvisor_Repository extends JpaRepository<ServiceAdvisor, Integer> {

}
