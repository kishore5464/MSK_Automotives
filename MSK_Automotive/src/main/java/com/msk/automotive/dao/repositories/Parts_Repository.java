package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Parts;

@Repository
public interface Parts_Repository extends JpaRepository<Parts, Integer> {

	@Query(value = "SELECT p FROM Parts p WHERE p.parts_status=:parts_status")
	public List<Parts> findByPartsStatus(@Param("parts_status") String parts_status);

	@Query(value = "SELECT p FROM Parts p WHERE p.car_models_id=:car_models_id")
	public List<Parts> findByCarModels(@Param("car_models_id") Integer car_models_id);

	@Query(value = "SELECT p FROM Parts p WHERE p.car_models_id=:car_models_id AND p.part=:part")
	public List<Parts> findByCarModelsAndPart(@Param("car_models_id") Integer car_models_id,
			@Param("part") String part);

}
