package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Parts;

@Repository
public interface Parts_Repository extends JpaRepository<Parts, Integer> {

	@Query(value = "SELECT p FROM PARTS p where p.parts_status=:parts_status")
	List<Parts> findByParts_status(@Param("parts_status") String parts_status);

	@Query(value = "SELECT p FROM PARTS p where p.car_models_id=:car_models_id")
	List<Parts> findByCar_Models(@Param("car_models_id") Integer car_models_id);

	@Query(value = "SELECT p FROM PARTS p where p.car_models_id=:car_models_id AND p.part=:part")
	List<Parts> findByCar_ModelsAndPart(@Param("car_models_id") Integer car_models_id, @Param("part") String part);
}
