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

}
