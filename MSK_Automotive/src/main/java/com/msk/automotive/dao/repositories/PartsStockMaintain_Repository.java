package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Parts_Stock_Maintain;

@Repository
public interface PartsStockMaintain_Repository extends JpaRepository<Parts_Stock_Maintain, Integer> {

}
