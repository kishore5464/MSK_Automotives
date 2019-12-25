package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Service_Advisor;

@Repository
public interface ServiceAdvisor_Repository extends JpaRepository<Service_Advisor, Integer> {

}
