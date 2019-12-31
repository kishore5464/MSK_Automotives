package com.msk.automotive.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msk.automotive.service.entities.Notification;

@Repository
public interface Notification_Repository extends JpaRepository<Notification, Integer> {

}
