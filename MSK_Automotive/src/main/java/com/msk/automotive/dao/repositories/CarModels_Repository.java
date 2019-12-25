package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Car_Models;

@Repository
public interface CarModels_Repository extends JpaRepository<Car_Models, Integer> {

}
