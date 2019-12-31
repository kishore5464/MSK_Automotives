package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.PartsStockMaintain;

@Repository
public interface PartsStockMaintain_Repository extends JpaRepository<PartsStockMaintain, Integer> {

}
