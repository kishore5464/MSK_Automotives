package com.msk.automotive.dao.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.CarBrands;

@Repository
public interface CarBrand_Repository extends JpaRepository<CarBrands, Integer> {

	public List<CarBrands> findByBrand(String brand);

}
