package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Parts;

@Repository
public interface Parts_Repository extends JpaRepository<Parts, Integer> {

}
