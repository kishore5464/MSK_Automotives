package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Car_Brands;

@Repository
public interface CarBrand_Repository extends JpaRepository<Car_Brands, Integer> {

}
