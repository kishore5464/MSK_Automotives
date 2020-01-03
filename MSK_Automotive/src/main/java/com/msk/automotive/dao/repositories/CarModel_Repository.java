package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.CarModels;

@Repository
public interface CarModel_Repository extends JpaRepository<CarModels, Integer> {

	@Query(value = "SELECT models FROM CarModels models WHERE models.carBrandsId = :carBrandsId")
	List<CarModels> findByCarBrandsId(@Param("carBrandsId") Integer carBrandsId);

}
