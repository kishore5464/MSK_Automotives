package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Location;

@Repository
public interface Location_Repository extends JpaRepository<Location, Integer> {

	@Query(value = "SELECT location FROM Location location WHERE location.city = :city")
	public List<Location> findByCity(@Param(value = "city")String city);
	
}
