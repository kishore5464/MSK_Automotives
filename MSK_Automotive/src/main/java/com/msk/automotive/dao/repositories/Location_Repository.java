package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Location;

@Repository
public interface Location_Repository extends JpaRepository<Location, Integer> {

}
